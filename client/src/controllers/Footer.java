package controllers;

import client.Client;
import common.Answer;
import common.Query;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Window;
import javafx.util.Pair;

import java.net.URL;
import java.util.*;

public class Footer implements Initializable {

    public Label time_left;

    private static long begin;
    private static long end;

    private enum Status {
        WAIT,
        NO_CHAMPIONSHIP
    }

    private static Status status;

    private static void loadChampionship() {
        Answer answer = Client.request(new Query(Query.Type.LOAD_CHAMPIONSHIP));
        if (answer.status == Answer.Status.OK) {
            status = Status.WAIT;
            Platform.runLater(() -> {
                Controllers.main.championship.setText(answer.championship);
                Controllers.main.address.setText(answer.address);
                Controllers.hcal.forEach(hc -> hc.championship.setText(answer.championship));
            });
            begin = answer.begin;
            end = answer.end;
        } else {
            status = Status.NO_CHAMPIONSHIP;
            Platform.runLater(() -> {
                Controllers.main.championship.setText("No championship");
                Controllers.main.address.setText("");
                Controllers.hcal.forEach(hc -> hc.championship.setText("No championship"));
                Controllers.fcal.forEach(hc -> hc.time_left.setText(""));
            });
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Controllers.fcal.add(this);
    }

    private static Pair<Window, Footer> findShowing() {
        Window w;
        for (var fc :
                Controllers.fcal) {
            w = fc.time_left.getScene().getWindow();
            if (w.isShowing())
                return new Pair<>(w, fc);
        }
        return null;
    }

    private static String getTimeLeft(long future, long now, String moment) {
        long diff = (future - now) / 60000;
        long minutes = diff % 60;
        diff /= 60;
        long hours = diff % 24;
        diff /= 24;
        long days = diff;
        return String.format(
                "%s дней %s часов и %s минут до %s чемпионата!",
                days,
                hours,
                minutes,
                moment
        );
    }

    private static void setTimeLeft() throws Exception {
        Pair<Window, Footer> tmp = findShowing();//while
        Window w = tmp.getKey();
        Footer fc = tmp.getValue();
        while (w.isShowing()) {//???
            long now = new Date().getTime();
            if (now < begin)
                Platform.runLater(() -> fc.time_left.setText(getTimeLeft(begin, now, "начала")));
            else if (now < end)
                Platform.runLater(() -> fc.time_left.setText(getTimeLeft(end, now, "конца")));
            else {//???
                loadChampionship();
                continue;
            }
            Thread.sleep(1000);//???
        }
        Platform.runLater(() -> fc.time_left.setText(""));//чтобы не оставлять прошлую строку
    }

    public static void startThread() {
        Thread thread = new Thread(
                new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        loadChampionship();
                        while (status == Status.WAIT)
                            setTimeLeft();
                        return null;
                    }
                }
        );
        thread.setDaemon(true);
        thread.start();
    }
}
