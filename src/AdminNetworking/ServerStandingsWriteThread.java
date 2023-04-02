package AdminNetworking;

import AdminNetworking.NetworkUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import online.judge.Stands;

public class ServerStandingsWriteThread implements Runnable{
    Thread t;
    NetworkUtil nc;
    ArrayList<Stands>ara;

    public ServerStandingsWriteThread(NetworkUtil nc,ArrayList<Stands>ara) {
        this.nc=nc;       
        this.ara=ara;
        t=new Thread(this);
        t.start();
    }
    
    
    @Override
    public void run() {
        for(int i=0;i<ara.size();i++){
            Stands info=ara.get(i);
            nc.write(info.name);
            nc.write(info.point);
        }
        nc.closeConnection();
        System.out.println("Connection Closed");
    }
}