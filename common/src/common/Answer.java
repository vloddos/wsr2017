package common;

import java.io.Serializable;

public class Answer implements Serializable {

    public enum Status {
        OK,
        ERROR
    }

    public Status status;
    public String message;

    public User user;

    public MyCompetenceData data;

    public long begin;
    public long end;
    public String address;

    public String championship;
    public String number;
    public String mark;
    public String modules;

    public Answer(Status status) {
        this.status = status;
    }

    public Answer(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public static Answer createLOGIN(User user) {
        Answer answer = new Answer(Status.OK);
        answer.user = user;
        return answer;
    }

    public static Answer createLOAD_MY_COMPETENCE(MyCompetenceData data) {
        Answer answer = new Answer(Status.OK);
        answer.data = data;
        return answer;
    }

    public static Answer createLOAD_MY_RESULTS(String championship, String number, String mark, String modules) {
        Answer answer = new Answer(Status.OK);
        answer.championship = championship;
        answer.number = number;
        answer.mark = mark;
        answer.modules = modules;
        return answer;
    }

    public static Answer createLOAD_CHAMPIONSHIP(String championship, long begin, long end, String address) {
        Answer answer = new Answer(Status.OK);
        answer.championship = championship;
        answer.begin = begin;
        answer.end = end;
        answer.address = address;
        return answer;
    }
}