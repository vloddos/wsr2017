import common.*;

import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.net.*;
import java.util.Date;

public class Server {

    private Socket socket;
    private static TreeMap<Long, Integer> session_id = new TreeMap<>();

    private static final String url = "jdbc:mysql://localhost:3306/wsr2017_db?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "rootmysql";

    private static Connection con;
    private static ResultSet rs;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static String now;

    public static void main(String[] args) {
        try (
                var socket = new ServerSocket(9027);
                var con = DriverManager.getConnection(url, user, password)
        ) {
            Server.con = con;
            System.out.println(Server.con);
            System.out.println(socket);
            while (true)
                new Server(socket.accept()).run();
        } catch (Exception err) {
            System.out.println("ERROR: " + err);
        }
    }

    private Server(Socket socket) {
        this.socket = socket;
    }

    private void run() {
        try (
                var out = new ObjectOutputStream(socket.getOutputStream());
                var src = new ObjectInputStream(socket.getInputStream())
        ) {
            out.writeObject(parseQuery((Query) src.readObject()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Answer parseQuery(Query query) {
        try {
            switch (query.type) {
                case LOGIN:
                    rs = con.createStatement().executeQuery("SELECT * FROM users WHERE email = " + "'" + query.email + "'");
                    if (rs.next() && query.password.equals(rs.getString("password"))) {
                        long session = new Random().nextLong();
                        session_id.put(session, rs.getInt("id"));

                        ResultSet regionResultSet = con.createStatement().executeQuery(
                                "SELECT `name` FROM users, regions " +//select * ???
                                        "WHERE email = '" + query.email + "' AND " +
                                        "regions.id = " + rs.getString("regioncode")
                        );
                        regionResultSet.next();

                        ResultSet competenceResultSet = con.createStatement().executeQuery(
                                "SELECT skills.id, `name` FROM users, skills " +
                                        "WHERE email = '" + query.email + "' AND " +
                                        "skills.id = competencenumber;"
                        );
                        competenceResultSet.next();

                        System.out.println("session " + session + " open");
                        return Answer.createLOGIN(
                                new User(
                                        query.email,
                                        rs.getString("firstname"),
                                        rs.getString("lastname"),
                                        competenceResultSet.getString(1),
                                        competenceResultSet.getString(2),
                                        rs.getString("role").charAt(0),
                                        rs.getString("gender").charAt(0),
                                        rs.getString("dateofbirth"),
                                        regionResultSet.getString(1)
                                )
                        );
                    } else
                        return new Answer(Answer.Status.ERROR, "Wrong email or password");

                case CHANGE_PASSWORD:
                    con.createStatement().executeUpdate("UPDATE users SET `password` = '" + query.password + "' WHERE email = '" + query.email + "';");
                    break;

                case LOAD_MY_COMPETENCE:
                    ResultSet competitorResultSet = con.createStatement().executeQuery(
                            "SELECT firstname,lastname,`name` FROM users, regions " +
                                    "WHERE competencenumber = '" + query.competencenumber + "' AND " +
                                    "regioncode = regions.id AND " +
                                    "`role` = 'C';");

                    ResultSet expertResultSet = con.createStatement().executeQuery(
                            "SELECT firstname,lastname,`name` FROM users, regions " +
                                    "WHERE competencenumber = '" + query.competencenumber + "' AND " +
                                    "regioncode = regions.id AND " +
                                    "`role` = 'E';");

                    return Answer.createLOAD_MY_COMPETENCE(new MyCompetenceData(competitorResultSet, expertResultSet));

                case LOAD_MY_RESULTS:
                    now = sdf.format(new Date());
                    ResultSet championshipResultSet = con.createStatement().executeQuery(
                            "SELECT `name` FROM wsi " +
                                    "WHERE `end` <= cast('" + now + "' AS DATETIME) OR " +
                                    "cast('" + now + "' AS DATETIME) >= `begin` AND cast('" + now + "' AS DATETIME) < `end` " +
                                    "ORDER BY `begin` DESC " +
                                    "limit 1;"
                    );
                    championshipResultSet.next();

                    rs = con.createStatement().executeQuery("SELECT id FROM users WHERE email = '" + query.email + "';");
                    rs.next();
                    String id = rs.getString(1);

                    ResultSet numberResultSet = con.createStatement().executeQuery(
                            "SELECT rn FROM " +
                                    "(SELECT id,row_number() over() AS rn FROM users WHERE competencenumber = '" + query.competencenumber + "' AND `role` = 'C') AS t " +
                                    "WHERE id = " + id + ";"
                    );
                    numberResultSet.next();

                    ResultSet mark_modulesResultSet = con.createStatement().executeQuery(
                            "SELECT mark, modules FROM results WHERE userid = " + id + ";"
                    );
                    mark_modulesResultSet.next();

                    return
                            Answer.createLOAD_MY_RESULTS(
                                    championshipResultSet.getString(1),
                                    numberResultSet.getString(1),
                                    mark_modulesResultSet.getString(1),
                                    mark_modulesResultSet.getString(2)
                            );

                case LOAD_CHAMPIONSHIP:
                    now = sdf.format(new Date());

                    rs = con.createStatement().executeQuery(
                            "SELECT `name`, `begin`, `end`, address FROM wsi WHERE " +
                                    "cast('" + now + "' AS DATETIME) >= `begin` AND " +
                                    "cast('" + now + "' AS DATETIME) < `end`;"
                    );

                    if (!rs.next())
                        rs = con.createStatement().executeQuery(
                                "SELECT `name`, `begin`, `end`, address FROM wsi WHERE " +
                                        "cast('" + now + "' AS DATETIME) < `begin` limit 1;"
                        );
                    else
                        rs.previous();

                    return
                            rs.next() ?
                                    Answer.createLOAD_CHAMPIONSHIP(
                                            rs.getString(1),
                                            sdf.parse(rs.getString(2)).getTime(),
                                            sdf.parse(rs.getString(3)).getTime(),
                                            rs.getString(4)
                                    ) :
                                    new Answer(Answer.Status.ERROR);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}