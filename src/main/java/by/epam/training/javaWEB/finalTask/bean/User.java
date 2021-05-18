package by.epam.training.javaWEB.finalTask.bean;


import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private int id;
    private String login;
    private String password;
    private Role role;
    private UserStatus status;

    private UserDetail userDetail = new UserDetail();

    public User() {
    }

    public User(String login, String password, int role) {
        this.login = login;
        this.password = password;
        switch (role) {
            case 1:
                this.role = Role.ADMIN;
                break;
            case 2:
                this.role = Role.CLIENT;
                break;
            case 3:
                this.role = Role.COURIER;
                break;
            case 4:
                this.role = Role.SERVICE_STAFF;
                break;
            default:
                this.role = Role.CLIENT;
                break;
        }
    }

    public User(int id, String login, String password, int role) {
        this.id = id;
        this.login = login;
        this.password = password;
        switch (role) {
            case 1:
                this.role = Role.ADMIN;
                break;
            case 2:
                this.role = Role.CLIENT;
                break;
            case 3:
                this.role = Role.COURIER;
                break;
            case 4:
                this.role = Role.SERVICE_STAFF;
                break;
            default:
                this.role = Role.CLIENT;
                break;
        }
    }

    public User(int id, String login, String password, int role, int status) {
        this.id = id;
        this.login = login;
        this.password = password;
        switch (role) {
            case 1:
                this.role = Role.ADMIN;
                break;
            case 3:
                this.role = Role.COURIER;
                break;
            case 4:
                this.role = Role.SERVICE_STAFF;
                break;
            default:
                this.role = Role.CLIENT;
                break;
        }
        switch (status) {
            case 2:
                this.status = UserStatus.LOCKED;
                break;
            case 3:
                this.status = UserStatus.DELETED;
                break;
            default:
                this.status = UserStatus.ACTIVE;
                break;
        }
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(int status) {

        switch (status) {
            case 2:
                this.status = UserStatus.LOCKED;
                break;
            case 3:
                this.status = UserStatus.DELETED;
                break;
            default:
                this.status = UserStatus.ACTIVE;
                break;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(int role) {
        switch (role) {
            case 1:
                this.role = Role.ADMIN;
                break;
            case 3:
                this.role = Role.COURIER;
                break;
            case 4:
                this.role = Role.SERVICE_STAFF;
                break;
            default:
                this.role = Role.CLIENT;
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return role == user.role &&
                login.equals(user.login) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
}
