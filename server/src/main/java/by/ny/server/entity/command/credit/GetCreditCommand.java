package by.ny.server.entity.command.credit;

import java.io.Serializable;

public class GetCreditCommand implements Serializable {
    private static final long serialVersionUID = 3584335554301394929L;

    private Integer creditId;

    public GetCreditCommand(Integer creditId) {
        this.creditId = creditId;
    }

    public Integer getCreditId() {
        return creditId;
    }

    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
    }
}
