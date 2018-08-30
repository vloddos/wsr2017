package common;

import java.io.Serializable;

public class Query implements Serializable {

    public enum Type {
        LOGIN,
        CHANGE_PASSWORD,
        LOAD_MY_COMPETENCE,
        LOAD_MY_RESULTS,
        LOAD_CHAMPIONSHIP
    }

    public Type type;

    public String email;
    public String password;
    public String competencenumber;

    public Query(Type type) {
        this.type = type;
    }

    public static Query createLOGIN(String email, String password) {
        Query query = new Query(Type.LOGIN);
        query.email = email;
        query.password = password;
        return query;
    }

    public static Query createCHANGE_PASSWORD(String email, String password) {
        Query query = new Query(Type.CHANGE_PASSWORD);
        query.email = email;
        query.password = password;
        return query;
    }

    public static Query createLOAD_MY_COMPETENCE(String competencenumber) {
        Query query = new Query(Type.LOAD_MY_COMPETENCE);
        query.competencenumber = competencenumber;
        return query;
    }

    public static Query createLOAD_MY_RESULTS(String email, String competencenumber) {
        Query query = new Query(Type.LOAD_MY_RESULTS);
        query.email = email;
        query.competencenumber = competencenumber;
        return query;
    }
}