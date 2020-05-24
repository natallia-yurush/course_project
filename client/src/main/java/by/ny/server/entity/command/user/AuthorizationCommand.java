package by.ny.server.entity.command.user;

import java.io.Serializable;

public class AuthorizationCommand implements Serializable {
    private static final long serialVersionUID = 8671181965462516475L;

    private String passportNumber;
    private String password;

    public AuthorizationCommand(String passportNumber, String password) {
        this.passportNumber = passportNumber;
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
