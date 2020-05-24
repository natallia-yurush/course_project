package by.ny.server.entity.result.user;

import by.ny.server.entity.command.user.*;
import by.ny.server.entity.User;

import java.io.Serializable;

public class GetSingleUserResult implements Serializable {
    private static final long serialVersionUID = -1465559724695984098L;

    private User user;

    public GetSingleUserResult(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
