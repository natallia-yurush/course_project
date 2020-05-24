package by.ny.server.entity.result.credit;

import java.io.Serializable;

public class UpdateCreditStatusResult implements Serializable {
    private static final long serialVersionUID = -7335965822428719649L;

    private boolean success;

    public UpdateCreditStatusResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
