package by.ny.server.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -5864874951155886442L;

    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String passportNumber;
    private UserRole role;
    private String password;

    public User(Integer id, String firstName, String lastName, String middleName, String passportNumber, UserRole role, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.passportNumber = passportNumber;
        this.role = role;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return this.lastName + " " + this.firstName + " " + this.middleName;
    }
}
