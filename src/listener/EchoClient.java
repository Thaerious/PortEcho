/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Ed Armstrong
 */
public class EchoClient {
        public static void main(String[] args) throws IOException {
        String address = "127.0.0.1";
        int port = 9090;
        if (args.length > 0){
            address = args[0];
            port = Integer.parseInt(args[1]);
        }
        new EchoClient(address, port);
    }

    private EchoClient(String address, int port) throws IOException {
        System.out.println("Echo Client Running");
        Socket socket = new Socket(address, port);
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        String line = scanner.nextLine();
        while (line != null){
            if (line.equals("quit")) break;
            System.out.println("client> " + line);  
            out.println(line);
            line = scanner.nextLine();
        }
    }
}
