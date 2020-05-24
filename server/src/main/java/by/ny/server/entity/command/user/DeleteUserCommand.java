package by.ny.server.entity.command.user;

import java.io.Serializable;

public class DeleteUserCommand implements Serializable {
    private static final long serialVersionUID = 1386195084234941836L;

    private Integer userId;

    public DeleteUserCommand(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
