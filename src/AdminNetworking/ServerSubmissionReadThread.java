package AdminNetworking;

import AdminNetworking.NetworkUtil;
import Compilor.RunIt;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import online.judge.AdminOnlineJudge;
import online.judge.Stats;

public class ServerSubmissionReadThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;
                  AdminOnlineJudge main;
                  String s;
                  String username;
                  String filename;
                  int Problem_No;
                  
	public ServerSubmissionReadThread(NetworkUtil nc,AdminOnlineJudge OJ) {
                        this.nc = nc;
                        main=OJ;
                        this.thr = new Thread(this);
                        thr.start();
	}
	
	public void run() {
            try {
                try {
                    username=(String)nc.read();
                    Problem_No=(int)nc.read();
                    
                    filename=(String)nc.read();
                  
                    File file=new File(filename);
                    if(!file.exists()) file.createNewFile();
                    FileWriter fw=new FileWriter(file);
                    PrintWriter pw=new PrintWriter(fw,true);
                    
                    while(true) {
                        s=(String)nc.read();
                        if(s.equals("$")) break;
                        pw.println(s);
                    }
                } catch(Exception e) {
                    System.out.println (e);
                    nc.closeConnection();
                }
                // String verdict="Accepted";
                
                RunIt ri=new RunIt();
                String verdict=ri.output(main.inAra.get(Problem_No),main.outAra.get(Problem_No),filename);
                
                System.out.println("Verdict:"+verdict);
                main.statuses.add(new Stats(username,Problem_No,verdict));
                
                if(verdict.equals("Accepted")){
                    for(int i=0;i<main.user.size();i++){
                        if(main.user.get(i).name.equals(username)){
                            main.user.get(i).point+=100;
                            break;
                        }
                    }
                }
                nc.closeConnection();
            } catch(IOException ex) {
                Logger.getLogger(ServerSubmissionReadThread.class.getName()).log (Level.SEVERE, null,ex);
            }
	}
}



