package client;

import common.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static Answer request(Query query) {
        try (
                var socket = new Socket("localhost", 9027);
                var in = new ObjectInputStream(socket.getInputStream());
                var out = new ObjectOutputStream(socket.getOutputStream())
        ) {
            out.writeObject(query);
            return (Answer) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
