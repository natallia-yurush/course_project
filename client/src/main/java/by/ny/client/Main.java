package by.ny.client;

import by.ny.client.ui.AuthorizationDialog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuthorizationDialog().setVisible(true);
            }
        });
    }
}
