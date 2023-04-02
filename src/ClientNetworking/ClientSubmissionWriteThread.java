package ClientNetworking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import online.judge.UserOnlineJudge;

public class ClientSubmissionWriteThread implements Runnable {

	private Thread thr;
	private NetworkUtil nc;
                  UserOnlineJudge main;
                  File file=null;
	String name;
                  int flag=0;
                  int problem;

	public ClientSubmissionWriteThread(NetworkUtil nc,File fp,UserOnlineJudge OJ,int prob_num) {
                        this.nc = nc;
                        this.name=name;
                        file=fp;
                        main=OJ;
                        problem=prob_num;
                        
                        this.thr = new Thread(this);
                        thr.start();
	}
	
	public void run() {
                        try {
                           Scanner input = new Scanner(file);
                           nc.write(main.username);
                           nc.write(problem);
                           nc.write(file.getName());
                           
                           System.out.println(file.getName());
                           while (true) {                           
                               while(input.hasNextLine()){
                                   flag=1;
                                   String s=input.nextLine();
                                   nc.write(s);
                                }
                               if(flag==1) {nc.write("$");break;}
                          }
                          } catch(Exception e) {
                                System.out.println (e);
                          }
                          nc.closeConnection();
                            //System.out.println("Ended");
                    }
}



