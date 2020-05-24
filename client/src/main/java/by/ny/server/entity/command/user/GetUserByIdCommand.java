package by.ny.server.entity.command.user;

import java.io.Serializable;

public class GetUserByIdCommand implements Serializable {
    private static final long serialVersionUID = 1249680755198531495L;

    private Integer userId;

    public GetUserByIdCommand(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
