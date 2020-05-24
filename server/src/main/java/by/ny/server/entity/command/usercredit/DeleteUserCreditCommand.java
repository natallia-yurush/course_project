package by.ny.server.entity.command.usercredit;

import java.io.Serializable;

public class DeleteUserCreditCommand implements Serializable {
    private static final long serialVersionUID = -6605595397897893507L;

    private Integer id;

    public DeleteUserCreditCommand(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
