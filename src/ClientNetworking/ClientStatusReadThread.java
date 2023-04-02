package ClientNetworking;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import online.judge.Stats;

public class ClientStatusReadThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;
                  int prob_num=0;
                  FileWriter fw;
                  PrintWriter pw;
                  ArrayList<Stats>ara;

	public ClientStatusReadThread(NetworkUtil nc,ArrayList<Stats>ara) {
                        this.nc = nc;
                        this.ara=ara;
                        this.thr = new Thread(this);
                        thr.start();
	}
	
	public void run() {
		try {
                                            ara.clear();
                                            while(true) {
                                                    String username=(String)nc.read();
                                                    int problem_no=(int)nc.read();
                                                    String verdict=(String)nc.read();
                                                    ara.add(new Stats(username,problem_no,verdict));
                                                    System.out.println(username+" "+problem_no+" "+verdict);
                                            }
		} catch(Exception e) {
			System.out.println (e);                        
		}
		nc.closeConnection();
	}
}



