/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ed Armstrong
 */
public class EchoServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int port = 9090;
        if (args.length > 0) port = Integer.parseInt(args[0]);
        new EchoServer(port);
    }
    
    public EchoServer(int port) throws IOException{
        System.out.println("Echo Server Waiting for Connection");
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();        
        this.echo(clientSocket);
        clientSocket.close();
        serverSocket.close();
    }
    
    public void echo(Socket clientSocket) throws IOException{
        System.out.println("Echo Server Listening");
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String line = in.readLine();
        while(line != null){
            if (line.equals("quit")) break;
            System.out.println("server> " + line);       
            line = in.readLine();
        }
    }
}
