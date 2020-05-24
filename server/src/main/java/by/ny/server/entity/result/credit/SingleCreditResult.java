package by.ny.server.entity.result.credit;

import by.ny.server.entity.Credit;

import java.io.Serializable;

public class SingleCreditResult implements Serializable {
    private static final long serialVersionUID = -6934120610238873014L;

    private Credit credit;

    public SingleCreditResult(Credit credit) {
        this.credit = credit;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }
}
