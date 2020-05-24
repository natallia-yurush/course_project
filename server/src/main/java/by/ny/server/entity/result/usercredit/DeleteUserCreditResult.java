package by.ny.server.entity.result.usercredit;

import java.io.Serializable;

public class DeleteUserCreditResult implements Serializable {
    private static final long serialVersionUID = 2382978001600958188L;

    private boolean success;

    public DeleteUserCreditResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
