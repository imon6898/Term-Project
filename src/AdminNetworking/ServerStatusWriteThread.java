package AdminNetworking;

import AdminNetworking.NetworkUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.MediaPlayer;
import online.judge.Stats;

public class ServerStatusWriteThread implements Runnable{
    Thread t;
    NetworkUtil nc;
    ArrayList<Stats>ara;

    public ServerStatusWriteThread(NetworkUtil nc,ArrayList<Stats>ara) {
        this.nc=nc;       
        this.ara=ara;
        t=new Thread(this);
        t.start();
    }    

    
    @Override
    public void run() {
        for(int i=0;i<ara.size();i++){
            Stats stat=ara.get(i);
            nc.write(stat.username);
            nc.write(stat.Problem_no);
            nc.write(stat.verdict);
        }
        nc.closeConnection();
        System.out.println("Connection Closed");
    }
}