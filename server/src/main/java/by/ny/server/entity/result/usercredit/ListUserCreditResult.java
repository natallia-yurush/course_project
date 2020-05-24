package by.ny.server.entity.result.usercredit;

import by.ny.server.entity.UserCredit;

import java.io.Serializable;
import java.util.List;

public class ListUserCreditResult implements Serializable {
    private static final long serialVersionUID = 6972373611421747147L;

    private List<UserCredit> userCredits;

    public ListUserCreditResult(List<UserCredit> userCredits) {
        this.userCredits = userCredits;
    }

    public List<UserCredit> getUserCredits() {
        return userCredits;
    }

    public void setUserCredits(List<UserCredit> userCredits) {
        this.userCredits = userCredits;
    }
}
