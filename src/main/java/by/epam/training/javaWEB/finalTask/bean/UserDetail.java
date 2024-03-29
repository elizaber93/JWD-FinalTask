package by.epam.training.javaWEB.finalTask.bean;

import java.io.Serializable;
import java.util.Objects;

public class UserDetail implements Serializable {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String imageLink;
    private int userId;

    public UserDetail() {
    }

    public UserDetail(int userId, String firstName, String lastName, String phone, String email, String address, String imageLink) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.imageLink = imageLink;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetail)) return false;
        UserDetail that = (UserDetail) o;
        return userId == that.userId &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                phone.equals(that.phone) &&
                email.equals(that.email) &&
                address.equals(that.address) &&
                imageLink.equals(that.imageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, phone, email, address, imageLink);
    }
}

