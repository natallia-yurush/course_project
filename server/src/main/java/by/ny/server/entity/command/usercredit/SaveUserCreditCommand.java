package by.ny.server.entity.command.usercredit;

import by.ny.server.entity.UserCredit;

import java.io.Serializable;

public class SaveUserCreditCommand implements Serializable {
    private static final long serialVersionUID = -8288825989025488539L;

    private UserCredit userCredit;

    public SaveUserCreditCommand(UserCredit userCredit) {
        this.userCredit = userCredit;
    }

    public UserCredit getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(UserCredit userCredit) {
        this.userCredit = userCredit;
    }
}
