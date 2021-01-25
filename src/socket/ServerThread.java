/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 
 * @author ahmadfadlydziljalal <ahmadfadldziljalal@gmail.com>
 */
public class ServerThread implements Runnable{

    private InputStream in;
    private OutputStream out;

    public ServerThread(Socket client) throws IOException {
        in = client.getInputStream();
        out = client.getOutputStream();
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

}
