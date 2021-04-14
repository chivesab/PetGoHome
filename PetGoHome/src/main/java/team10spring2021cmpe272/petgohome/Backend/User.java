package team10spring2021cmpe272.petgohome.Backend;

public class User {
    private String userName;
    private String userPassword;
    private String userHashedPassword;
    private String phone;

    public User(String userName, String userHashedPassword, String phone) {
        this.userName = userName;
        this.userHashedPassword = userHashedPassword;
        this.phone = phone;
    };

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }


    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getphone() {
        return phone;
    }
    public void setphone(String phone) {
        this.phone = phone;
    }
    public String getUserHashedPassword() {
        return userHashedPassword;
    }
    public void setUserHashedPassword(String userHashedPassword) {
        this.userHashedPassword = userHashedPassword;
    }

}
