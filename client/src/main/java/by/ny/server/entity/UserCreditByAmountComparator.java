/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.ny.server.entity;

import java.util.Comparator;

/**
 *
 * @author Natallia Yurush
 */
public class UserCreditByAmountComparator implements Comparator<UserCredit>{
    
    @Override
    public int compare(UserCredit userCredit1, UserCredit userCredit2) {
        return userCredit1.getIssueAmount().compareTo(userCredit2.getIssueAmount());
    }
}
