package by.ny.server.entity.command.credit;

import by.ny.server.entity.Credit;

import java.io.Serializable;

public class SaveCreditCommand implements Serializable {
    private static final long serialVersionUID = 6922471963209067419L;

    private Credit credit;

    public SaveCreditCommand(Credit credit) {
        this.credit = credit;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }
}
