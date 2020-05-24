package by.ny.server.entity.result.credit;

import by.ny.server.entity.Credit;

import java.io.Serializable;
import java.util.List;

public class CreditsResult implements Serializable {
    private static final long serialVersionUID = 2417134141503898245L;

    private List<Credit> credits;

    public CreditsResult(List<Credit> credits) {
        this.credits = credits;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }
}
