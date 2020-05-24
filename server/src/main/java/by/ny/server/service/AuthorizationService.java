package by.ny.server.service;

import by.ny.server.db.UserDao;
import by.ny.server.entity.User;

public class AuthorizationService {
    private UserDao userDao;

    public AuthorizationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User authenticate(String passportNumber, String password) {
        User user = userDao.findUserByPassportNumber(passportNumber);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}
