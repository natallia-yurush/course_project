package by.ny.server.entity.command.usercredit;

import by.ny.server.entity.UserCredit;

import java.io.Serializable;

public class PayUserCreditCommand implements Serializable {
    private static final long serialVersionUID = -6469594790964121718L;

    private UserCredit userCredit;
    private Double contribute_amount;

    public PayUserCreditCommand(UserCredit userCredit, Double contribute_amount) {
        this.contribute_amount = contribute_amount;
        this.userCredit = userCredit;
    }

    public UserCredit getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(UserCredit userCredit) {
        this.userCredit = userCredit;
    }

    public Double getContribute_amount() {
        return contribute_amount;
    }

    public void setContribute_amount(Double contribute_amount) {
        this.contribute_amount = contribute_amount;
    }
}
