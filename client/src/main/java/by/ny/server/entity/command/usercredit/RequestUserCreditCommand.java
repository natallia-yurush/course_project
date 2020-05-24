package by.ny.server.entity.command.usercredit;

import by.ny.server.entity.Credit;
import by.ny.server.entity.User;

import java.io.Serializable;

public class RequestUserCreditCommand implements Serializable {
    private static final long serialVersionUID = 5674883936972903527L;

    private Credit selectedCredit;
    private User currentUser;
    private Double requestedAmount;

    public RequestUserCreditCommand(Credit selectedCredit, User currentUser, Double requestedAmount) {
        this.selectedCredit = selectedCredit;
        this.currentUser = currentUser;
        this.requestedAmount = requestedAmount;
    }

    public Credit getSelectedCredit() {
        return selectedCredit;
    }

    public void setSelectedCredit(Credit selectedCredit) {
        this.selectedCredit = selectedCredit;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Double getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(Double requestedAmount) {
        this.requestedAmount = requestedAmount;
    }
}
