package by.ny.server.entity.command.usercredit;

import by.ny.server.entity.User;

import java.io.Serializable;

public class ListUserCreditCommand implements Serializable {
    private static final long serialVersionUID = 614939111772249788L;

    private User user;

    public ListUserCreditCommand(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
