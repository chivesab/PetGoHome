package team10spring2021cmpe272.petgohome.Backend;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String userName;
    private String userPassword;
    private String userHashedPassword;
    private String phone;
    private String email;

    public User() {
    }

    public User(String userName, String userHashedPassword, String phone) {
        this.userName = userName;
        this.userHashedPassword = userHashedPassword;
        this.phone = phone;
    };

    public User(String userName, String email, String userPassword, String phone) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
        this.phone = phone;
    }
}
