package by.ny.server.db;

import by.ny.server.entity.User;
import by.ny.server.entity.UserRole;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao {
    public User findUserByPassportNumber(String passportNumber) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT id, first_name, last_name, middle_name, passport_number, role, password FROM user WHERE passport_number=?");
            preparedStatement.setString(1, passportNumber);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new User(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        UserRole.valueOf(resultSet.getString(6).toUpperCase()), resultSet.getString(7));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<User> listUsers() {
        List<User> result = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, first_name, last_name, middle_name, passport_number, role, password FROM user");
            while (resultSet.next()) {
                result.add(new User(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        UserRole.valueOf(resultSet.getString(6).toUpperCase()), resultSet.getString(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public User getUserById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT id, first_name, last_name, middle_name, passport_number, role, password FROM user WHERE id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new User(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        UserRole.valueOf(resultSet.getString(6).toUpperCase()), resultSet.getString(7));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean deleteUser(Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM user WHERE id=?");
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveUser(User user) {
        try {
            PreparedStatement statement;
            if (user.getId() == null) {
                statement = connection.prepareStatement("INSERT INTO user (first_name, last_name, middle_name, passport_number, role, password) VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getMiddleName());
                statement.setString(4, user.getPassportNumber());
                statement.setString(5, user.getRole().toString());
                statement.setString(6, user.getPassword());
            } else {
                statement = connection.prepareStatement("UPDATE user SET first_name=?, last_name=?, middle_name=?, passport_number=?, role=?, password=? WHERE id=?");
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getMiddleName());
                statement.setString(4, user.getPassportNumber());
                statement.setString(5, user.getRole().toString());
                statement.setString(6, user.getPassword());
                statement.setInt(7, user.getId());
            }
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
