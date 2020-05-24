package by.ny.server.entity.command.usercredit;

import java.io.Serializable;

public class GetUserCreditByIdCommand implements Serializable {
    private static final long serialVersionUID = 6339481158610207682L;

    private Integer userCreditId;

    public GetUserCreditByIdCommand(Integer userId) {
        this.userCreditId = userId;
    }

    public Integer getUserCreditId() {
        return userCreditId;
    }

    public void setUserCreditId(Integer userId) {
        this.userCreditId = userId;
    }
}
