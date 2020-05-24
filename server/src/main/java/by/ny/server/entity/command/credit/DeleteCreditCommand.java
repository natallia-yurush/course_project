package by.ny.server.entity.command.credit;

import java.io.Serializable;

public class DeleteCreditCommand implements Serializable {
    private static final long serialVersionUID = 1331436922645408648L;

    private Integer creditId;

    public DeleteCreditCommand(Integer creditId) {
        this.creditId = creditId;
    }

    public Integer getCreditId() {
        return creditId;
    }

    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
    }
}
