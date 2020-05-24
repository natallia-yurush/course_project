package by.ny.server.entity.result.usercredit;

import java.io.Serializable;

public class RequestUserCreditResult implements Serializable {
    private static final long serialVersionUID = -7886624262116696771L;

    private boolean success;

    public RequestUserCreditResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
