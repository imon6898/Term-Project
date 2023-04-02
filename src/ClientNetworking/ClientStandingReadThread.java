package ClientNetworking;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import online.judge.Stands;

public class ClientStandingReadThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;
                  int prob_num=0;
                  FileWriter fw;
                  PrintWriter pw;
                  ArrayList<Stands>ara;

	public ClientStandingReadThread(NetworkUtil nc,ArrayList<Stands>ara) {
                        this.nc = nc;
                        this.ara=ara;
                        this.thr = new Thread(this);
                        thr.start();
	}
	
	public void run() {
		try {
                                            ara.clear();
                                            while(true) {
                                                    String name=(String)nc.read();
                                                    int point=(int)nc.read();
                                                    ara.add(new Stands(name, point));
                                            }
		} catch(Exception e) {
			System.out.println (e);                        
		}
		nc.closeConnection();
	}
}



