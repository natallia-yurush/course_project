package by.ny.server.service;

import by.ny.server.db.UserCreditDao;
import by.ny.server.entity.Credit;
import by.ny.server.entity.CreditStatus;
import by.ny.server.entity.User;
import by.ny.server.entity.UserCredit;

import java.util.Date;
import java.util.List;

public class UserCreditService {
    private UserCreditDao userCreditDao;

    public UserCreditService(UserCreditDao userCreditDao) {
        this.userCreditDao = userCreditDao;
    }

    public boolean requestCredit(Credit credit, User user, Double requestedAmount) {
        UserCredit userCredit = new UserCredit(null, new Date(), requestedAmount, requestedAmount / credit.getMaxTerm(),
                requestedAmount / credit.getMaxTerm() * credit.getPercent() / 1200, CreditStatus.REQUESTED, credit.getId(), user.getId(), 0.0);

        return userCreditDao.requestCredit(userCredit);
    }

    public boolean declineUserCredit(Integer userCreditId) {
        return userCreditDao.removeRequestedCredit(userCreditId);
    }

    public List<UserCredit> listUserCredits(User currentUser) {
        return userCreditDao.listUserCreditsByUser(currentUser.getId());
    }

    public UserCredit getUserCreditById(Integer userCreditId) {
        return userCreditDao.getUserCredit(userCreditId);
    }

    public boolean saveUserCreditStatus(UserCredit userCredit) {
        return userCreditDao.saveUserCreditStatus(userCredit);
    }

    public boolean contributeAmount(UserCredit userCredit, Double amount) {
        return userCreditDao.contributeAmount(userCredit, amount);
    }
}
