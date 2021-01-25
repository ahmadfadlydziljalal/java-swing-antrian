/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*

    1. Make Use of Java Socket Programming
    2. It starts a server which will be always running listening to a port 59090 (Server.java)
    3. Client (Client.java) sends a number (message) to the server
    4. Server receives this number and multiplies it by 2
    5. Server (Server.java) sends back the result (message) to the client (Client.java)
    6. In case the number sent by the client was not a proper number, server (Server.java) sends back the message “Please send a proper number” to the client (Client.java)

 */
package socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SocketServer extends Thread {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private int port = 59090;
    private boolean status;
    InputStreamReader inputStreamReader;
    BufferedReader bufferedReader;
    String message;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Constructor
     */
    public SocketServer() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {

        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                
                clientSocket = serverSocket.accept();
                
                inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                message = bufferedReader.readLine();
                
                System.out.println(message);
                
                
//                saveFile(clientSocket);
            } catch (IOException ex) {

            }
        }
    }

    @Override
    public void interrupt() {
        try {
            serverSocket.close();
        } catch (IOException ex) {

        }
    }

    private void saveFile(Socket clientSock) throws IOException {
        DataInputStream dis = new DataInputStream(clientSock.getInputStream());

        File root = new File("db_picture");

        if (!root.exists()) {
            root.mkdir(); //pastikan folder tersedia
        }
        /*
            Sementara hanya untuk test saja nama file nya
            Nanti dari Android App nya diterima dalam bentuk list file
         */
        File file = new File(root, "test.jpg");

        FileOutputStream fos = new FileOutputStream(file, false);
        byte[] buffer = new byte[4096];

        int filesize = 15123; // Send file size in separate msg
        int read = 0;
        int totalRead = 0;
        int remaining = filesize;

        while ((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
            totalRead += read;
            remaining -= read;
            System.out.println("read " + totalRead + " bytes.");
            fos.write(buffer, 0, read);
        }

        fos.close();
        dis.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SocketServer socketServerGudang = new SocketServer();
        socketServerGudang.start();
    }

}
