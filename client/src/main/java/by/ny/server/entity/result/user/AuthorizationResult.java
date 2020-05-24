package by.ny.server.entity.result.user;

import by.ny.server.entity.command.user.*;
import by.ny.server.entity.User;

import java.io.Serializable;

public class AuthorizationResult implements Serializable {
    private static final long serialVersionUID = -1950408034943904571L;

    private boolean authorized;
    private User user;

    public AuthorizationResult(boolean authorized, User user) {
        this.authorized = authorized;
        this.user = user;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
