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
public class UserNameComparator implements Comparator<User> {
    
    @Override
    public int compare(User user1, User user2) {
        return user1.toString().compareTo(user2.toString());
    }
    
}
