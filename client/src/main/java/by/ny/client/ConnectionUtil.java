/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.ny.client;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Natallia Yurush
 */
public class ConnectionUtil {
    public static Socket getSocket() throws IOException {
        return new Socket("localhost", 3333);
    }
}
