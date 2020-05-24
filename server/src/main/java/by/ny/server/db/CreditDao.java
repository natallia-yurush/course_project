package by.ny.server.db;

import by.ny.server.entity.Credit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CreditDao extends AbstractDao {
    public List<Credit> listCredits() {
        List<Credit> result = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, purpose, max_amount, percent, term_months FROM credit");
            while (resultSet.next()) {
                result.add(new Credit(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getDouble(3), resultSet.getInt(4), resultSet.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Credit getCreditById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT id, purpose, max_amount, percent, term_months FROM credit WHERE id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Credit(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getDouble(3), resultSet.getInt(4), resultSet.getInt(5));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean deleteCredit(Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM credit WHERE id=?");
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveCredit(Credit credit) {
        try {
            PreparedStatement statement;
            if (credit.getId() == null) {
                statement = connection.prepareStatement("INSERT INTO credit (purpose, max_amount, percent, term_months) VALUES (?, ?, ?, ?)");
                statement.setString(1, credit.getPurpose());
                statement.setDouble(2, credit.getMaxAmount());
                statement.setInt(3, credit.getPercent());
                statement.setInt(4, credit.getMaxTerm());
            } else {
                statement = connection.prepareStatement("UPDATE credit SET purpose=?, max_amount=?, percent=?, term_months=? WHERE id=?");
                statement.setString(1, credit.getPurpose());
                statement.setDouble(2, credit.getMaxAmount());
                statement.setInt(3, credit.getPercent());
                statement.setInt(4, credit.getMaxTerm());
                statement.setInt(5, credit.getId());
            }
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
