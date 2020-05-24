package by.ny.server.entity.result.usercredit;

import java.io.Serializable;

public class UpdateUserCreditStatusResult implements Serializable {
    private static final long serialVersionUID = -423730615838240780L;

    private boolean success;

    public UpdateUserCreditStatusResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
