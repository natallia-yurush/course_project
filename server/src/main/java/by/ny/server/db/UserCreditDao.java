package by.ny.server.db;

import by.ny.server.entity.*;
import by.ny.server.service.CreditService;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserCreditDao extends AbstractDao {
    public boolean requestCredit(UserCredit userCredit) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user_credit (issue_date, issue_amount, basic_monthly_payment, interest_monthly_payment, status, user_id, credit_id, contributed_amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setDate(1, new Date(userCredit.getIssueDate().getTime()));
            statement.setDouble(2, userCredit.getIssueAmount());
            statement.setDouble(3, userCredit.getBasicMonthlyPayment());
            statement.setDouble(4, userCredit.getInterestMonthlyPayment());
            statement.setString(5, userCredit.getStatus().toString());
            statement.setInt(6, userCredit.getUserId());
            statement.setInt(7, userCredit.getCreditId());
            statement.setDouble(8, userCredit.getContributed_amount());

            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeRequestedCredit(Integer userCreditId) {
        UserCredit userCredit = getUserCredit(userCreditId);

        if (userCredit.getStatus() != CreditStatus.REQUESTED) {
            return false;
        }

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM user_credit WHERE id=?");
            statement.setInt(1, userCreditId);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public UserCredit getUserCredit(Integer userCreditId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT id, issue_date, issue_amount, basic_monthly_payment, interest_monthly_payment, status, user_id, credit_id, contributed_amount FROM user_credit WHERE id=?");
            preparedStatement.setInt(1, userCreditId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new UserCredit(resultSet.getInt(1), new java.util.Date(resultSet.getDate(2).getTime()),
                        resultSet.getDouble(3), resultSet.getDouble(4), resultSet.getDouble(5),
                        CreditStatus.valueOf(resultSet.getString(6).toUpperCase()), resultSet.getInt(8), resultSet.getInt(7), resultSet.getDouble(9));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<UserCredit> listUserCreditsByUser(Integer userId) {
        List<UserCredit> userCredits = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT id, issue_date, issue_amount, basic_monthly_payment, interest_monthly_payment, status, user_id, credit_id, contributed_amount FROM user_credit WHERE user_id=?");
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userCredits.add(new UserCredit(resultSet.getInt(1), new java.util.Date(resultSet.getDate(2).getTime()),
                        resultSet.getDouble(3), resultSet.getDouble(4), resultSet.getDouble(5),
                        CreditStatus.valueOf(resultSet.getString(6).toUpperCase()), resultSet.getInt(8), resultSet.getInt(7), resultSet.getDouble(9)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userCredits;
    }

    public boolean saveUserCreditStatus(UserCredit userCredit) {

        if (userCredit.getStatus() == CreditStatus.ACTIVE) {
            return false;
        }

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE user_credit SET status = 'ACTIVE' WHERE id=?");
            statement.setInt(1, userCredit.getId());

            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean contributeAmount(UserCredit userCredit, Double amount) {
        if (userCredit.getStatus() == CreditStatus.CLOSED) {
            return false;
        }

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE user_credit SET contributed_amount = ?, status = ? WHERE id=?");
            statement.setInt(3, userCredit.getId());

            statement.setDouble(1, (userCredit.getContributed_amount() + amount));

            CreditDao creditDao = new CreditDao();
            CreditService creditService = new CreditService(creditDao);
            Credit credit = creditService.getCreditById(userCredit.getCreditId());

            Double d1 = userCredit.getContributed_amount() + amount;
            Double d2 = userCredit.getIssueAmount() + (userCredit.getIssueAmount() * credit.getPercent() / 1200);

            //if((userCredit.getContributed_amount() + amount) >= (userCredit.getIssueAmount() + (userCredit.getIssueAmount() * credit.getPercent() / 1200))) {
            if(d1 >= d2) {
                statement.setString(2,CreditStatus.CLOSED.toString());
            } else {
                statement.setString(2,CreditStatus.ACTIVE.toString());
            }

            statement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
