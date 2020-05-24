package by.ny.server;

import by.ny.server.db.CreditDao;
import by.ny.server.db.UserCreditDao;
import by.ny.server.db.UserDao;
import by.ny.server.entity.Credit;
import by.ny.server.entity.User;
import by.ny.server.entity.UserCredit;
import by.ny.server.entity.command.credit.DeleteCreditCommand;
import by.ny.server.entity.command.credit.GetCreditCommand;
import by.ny.server.entity.command.credit.ListCreditsCommand;
import by.ny.server.entity.command.credit.SaveCreditCommand;
import by.ny.server.entity.command.user.*;
import by.ny.server.entity.command.usercredit.*;
import by.ny.server.entity.result.credit.CreditsResult;
import by.ny.server.entity.result.credit.SingleCreditResult;
import by.ny.server.entity.result.credit.UpdateCreditStatusResult;
import by.ny.server.entity.result.user.AuthorizationResult;
import by.ny.server.entity.result.user.GetSingleUserResult;
import by.ny.server.entity.result.user.ListUsersResult;
import by.ny.server.entity.result.user.UpdateUserStatusResult;
import by.ny.server.entity.result.usercredit.*;
import by.ny.server.service.AuthorizationService;
import by.ny.server.service.CreditService;
import by.ny.server.service.UserCreditService;
import by.ny.server.service.UserService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            final UserDao userDao = new UserDao();
            final CreditDao creditDao = new CreditDao();
            final UserCreditDao userCreditDao = new UserCreditDao();
            final AuthorizationService authorizationService = new AuthorizationService(userDao);
            final UserService userService = new UserService(userDao);
            final CreditService creditService = new CreditService(creditDao);
            final UserCreditService userCreditService = new UserCreditService(userCreditDao);

            final ServerSocket ss = new ServerSocket(3333);

            while (true) {

                new Thread(() -> {
                    try (Socket s = ss.accept()) {
                        ObjectInputStream din = new ObjectInputStream(s.getInputStream());
                        ObjectOutputStream dout = new ObjectOutputStream(s.getOutputStream());

                        Object command = din.readObject();

                        if (command instanceof AuthorizationCommand) {
                            AuthorizationCommand authorizationCommand = (AuthorizationCommand) command;
                            User user = authorizationService.authenticate(authorizationCommand.getPassportNumber(), authorizationCommand.getPassword());
                            AuthorizationResult result = new AuthorizationResult(user != null, user);
                            dout.writeObject(result);
                        } else if (command instanceof ListUsersCommand) {
                            ListUsersResult listUsersResult = new ListUsersResult(userService.listUsers());
                            dout.writeObject(listUsersResult);
                        } else if (command instanceof GetUserByIdCommand) {
                            GetUserByIdCommand getUserByIdCommand = (GetUserByIdCommand) command;
                            Integer userId = getUserByIdCommand.getUserId();
                            User user = userService.getUserById(userId);
                            GetSingleUserResult result = new GetSingleUserResult(user);
                            dout.writeObject(result);
                        } else if (command instanceof DeleteUserCommand) {
                            DeleteUserCommand deleteUserCommand = (DeleteUserCommand) command;
                            boolean success = userService.deleteUser(deleteUserCommand.getUserId());
                            UpdateUserStatusResult result = new UpdateUserStatusResult(success);
                            dout.writeObject(result);
                        } else if (command instanceof SaveUserCommand) {
                            SaveUserCommand saveUserCommand = (SaveUserCommand) command;
                            boolean success = userService.saveUser(saveUserCommand.getUser());
                            UpdateUserStatusResult result = new UpdateUserStatusResult(success);
                            dout.writeObject(result);
                        } else if (command instanceof ListCreditsCommand) {
                            CreditsResult result = new CreditsResult(creditService.listCredits());
                            dout.writeObject(result);
                        } else if (command instanceof GetCreditCommand) {
                            GetCreditCommand getCreditCommand = (GetCreditCommand) command;
                            Credit credit = creditService.getCreditById(getCreditCommand.getCreditId());
                            SingleCreditResult singleCreditResult = new SingleCreditResult(credit);
                            dout.writeObject(singleCreditResult);
                        } else if (command instanceof SaveCreditCommand) {
                            SaveCreditCommand saveCreditCommand = (SaveCreditCommand) command;
                            boolean success = creditService.saveCredit(saveCreditCommand.getCredit());
                            UpdateCreditStatusResult result = new UpdateCreditStatusResult(success);
                            dout.writeObject(result);
                        } else if (command instanceof DeleteCreditCommand) {
                            DeleteCreditCommand deleteCreditCommand = (DeleteCreditCommand) command;
                            boolean success = creditService.deleteCredit(deleteCreditCommand.getCreditId());
                            UpdateCreditStatusResult result = new UpdateCreditStatusResult(success);
                            dout.writeObject(result);
                        } else if (command instanceof RequestUserCreditCommand) {
                            RequestUserCreditCommand requestUserCreditCommand = (RequestUserCreditCommand) command;
                            boolean success = userCreditService.requestCredit(requestUserCreditCommand.getSelectedCredit(), requestUserCreditCommand.getCurrentUser(),
                                    requestUserCreditCommand.getRequestedAmount());
                            RequestUserCreditResult result = new RequestUserCreditResult(success);
                            dout.writeObject(result);
                        } else if (command instanceof DeleteUserCreditCommand) {
                            DeleteUserCreditCommand deleteUserCreditCommand = (DeleteUserCreditCommand) command;
                            boolean success = userCreditService.declineUserCredit(deleteUserCreditCommand.getId());
                            DeleteUserCreditResult result = new DeleteUserCreditResult(success);
                            dout.writeObject(result);
                        } else if (command instanceof ListUserCreditCommand) {
                            ListUserCreditCommand listUserCreditCommand = (ListUserCreditCommand) command;
                            List<UserCredit> userCredits = userCreditService.listUserCredits(listUserCreditCommand.getUser());
                            ListUserCreditResult result = new ListUserCreditResult(userCredits);
                            dout.writeObject(result);
                        } else if (command instanceof GetUserCreditByIdCommand) {
                            GetUserCreditByIdCommand getUserCreditByIdCommand = (GetUserCreditByIdCommand) command;
                            Integer userCreditId = getUserCreditByIdCommand.getUserCreditId();
                            UserCredit userCredit = userCreditService.getUserCreditById(userCreditId);
                            SingleUserCreditResult result = new SingleUserCreditResult(userCredit);
                            dout.writeObject(result);
                        } else if(command instanceof SaveUserCreditCommand) {
                            SaveUserCreditCommand saveUserCreditCommand = (SaveUserCreditCommand) command;
                            boolean success = userCreditService.saveUserCreditStatus(saveUserCreditCommand.getUserCredit());
                            UpdateUserCreditStatusResult result = new UpdateUserCreditStatusResult(success);
                            dout.writeObject(result);
                        } else if(command instanceof PayUserCreditCommand) {
                            PayUserCreditCommand payUserCreditCommand = (PayUserCreditCommand) command;
                            boolean success = userCreditService.contributeAmount(payUserCreditCommand.getUserCredit(), payUserCreditCommand.getContribute_amount());
                            UpdateUserCreditStatusResult result = new UpdateUserCreditStatusResult(success);
                            dout.writeObject(result);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).run();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
