package by.epam.training.javaWEB.finalTask.bean;

import java.io.Serializable;
import java.util.Objects;

public class RegistrationInfo implements Serializable {
    private String login;
    private String password;
    private UserDetail userDetail = new UserDetail();

    public RegistrationInfo() {
    }

    public RegistrationInfo(String login, String password, UserDetail userDetail) {
        this.login = login;
        this.password = password;
        this.userDetail = userDetail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationInfo)) return false;
        RegistrationInfo that = (RegistrationInfo) o;
        return login.equals(that.login) &&
                password.equals(that.password) &&
                userDetail.equals(that.userDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, userDetail);
    }

    @Override
    public String toString() {
        return "RegistrationInfo{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userDetail=" + userDetail +
                '}';
    }
}
