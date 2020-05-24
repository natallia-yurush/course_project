package by.ny.server.entity.result.usercredit;

import by.ny.server.entity.UserCredit;

import java.io.Serializable;

public class SingleUserCreditResult implements Serializable {
    private static final long serialVersionUID = 4855265267767887119L;

    private UserCredit userCredit;

    public SingleUserCreditResult(UserCredit userCredit) {
        this.userCredit = userCredit;
    }

    public UserCredit getUser() {
        return userCredit;
    }

    public void setUser(UserCredit userCredit) {
        this.userCredit = userCredit;
    }
}
