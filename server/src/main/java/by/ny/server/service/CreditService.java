package by.ny.server.service;

import by.ny.server.db.CreditDao;
import by.ny.server.entity.Credit;

import java.util.List;

public class CreditService {
    private CreditDao creditDao;

    public CreditService(CreditDao creditDao) {
        this.creditDao = creditDao;
    }

    public List<Credit> listCredits() {
        return creditDao.listCredits();
    }

    public Credit getCreditById(Integer id) {
        return creditDao.getCreditById(id);
    }

    public boolean deleteCredit(Integer id) {
        return creditDao.deleteCredit(id);
    }

    public boolean saveCredit(Credit credit) {
        return creditDao.saveCredit(credit);
    }
}
