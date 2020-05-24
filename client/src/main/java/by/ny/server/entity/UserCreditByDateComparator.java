/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.ny.server.entity;

import by.ny.client.ConnectionUtil;
import by.ny.server.entity.command.credit.GetCreditCommand;
import by.ny.server.entity.result.credit.SingleCreditResult;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Natallia Yurush
 */
public class UserCreditByDateComparator implements Comparator<UserCredit> {
    
    @Override
    public int compare(UserCredit userCredit1, UserCredit userCredit2) {
        try {
            Socket socket = ConnectionUtil.getSocket();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(new GetCreditCommand(userCredit1.getCreditId()));
                            
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            SingleCreditResult result = (SingleCreditResult) inputStream.readObject();
            Credit credit = result.getCredit();

            socket.close();
                            
            Date date1 = new Date(userCredit1.getIssueDate().getTime());
            date1.setMonth(userCredit1.getIssueDate().getMonth() + credit.getMaxTerm());
               
            socket = ConnectionUtil.getSocket();
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(new GetCreditCommand(userCredit2.getCreditId()));
            
            inputStream = new ObjectInputStream(socket.getInputStream());
            result = (SingleCreditResult) inputStream.readObject();
            credit = result.getCredit();
            
            Date date2 = new Date(userCredit2.getIssueDate().getTime());
            date2.setMonth(userCredit2.getIssueDate().getMonth() + credit.getMaxTerm());
            
            socket.close();
               
            return date1.compareTo(date2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
       
    }
}
