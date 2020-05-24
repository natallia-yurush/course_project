package by.ny.server.entity.command.user;

import by.ny.server.entity.User;

import java.io.Serializable;

public class SaveUserCommand implements Serializable {
    private static final long serialVersionUID = 7699860328877593731L;

    private User user;

    public SaveUserCommand(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
