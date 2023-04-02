/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminNetworking;

import AdminNetworking.NetworkUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anik
 */
public class ServerProblemWriteThread  implements Runnable{
    Thread t;
    NetworkUtil nc;
    ArrayList<File>ara;

    public ServerProblemWriteThread(NetworkUtil nc,ArrayList<File>ara) {
        this.nc=nc;       
        this.ara=ara;
        t=new Thread(this);
        t.start();
    }
    
    
    @Override
    public void run() {
        for(int i=0;i<ara.size();i++){
            try {
                File fp=ara.get(i);
                Scanner sc=new Scanner(fp);
                nc.write("#");
                while(sc.hasNextLine()){
                    String line=sc.nextLine();
                    nc.write(line);
                }
            } catch (FileNotFoundException ex) {
                nc.closeConnection();
                Logger.getLogger(ServerProblemWriteThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        nc.closeConnection();
        System.out.println("Connection Closed");
    }
    
}
