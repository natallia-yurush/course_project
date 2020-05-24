package by.ny.server.entity.result.user;

import java.io.Serializable;

public class UpdateUserStatusResult implements Serializable {
    private static final long serialVersionUID = 7188062711867903204L;

    private boolean success;

    public UpdateUserStatusResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
