package common;

import java.io.Serializable;

public class User implements Serializable {

    public static User user;

    public String email;
    public String firstname;
    public String lastname;
    public String competencenumber;
    public String competencename;
    public char role;
    public char gender;
    public String dateofbirth;
    public String region;

    public User(String email, String firstname, String lastname, String competencenumber, String competencename,
                char role, char gender, String dateofbirth, String region) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.competencenumber = competencenumber;
        this.competencename = competencename;
        this.role = role;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
        this.region = region;
    }
}
