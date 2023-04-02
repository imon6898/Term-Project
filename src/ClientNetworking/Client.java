package ClientNetworking;

import java.io.File;
import java.util.ArrayList;
import online.judge.UserOnlineJudge;

public class Client 
{                 File fp=null;
                  NetworkUtil nc;
                  UserOnlineJudge main;
                  ArrayList<File>ara;
                  public Client(UserOnlineJudge OJ,String s){
                        try {
                                System.out.println("Client Started");
                                String serverAddress="127.0.0.1";
                                int serverPort=33333;
                                nc = new NetworkUtil(serverAddress,serverPort);
                                main=OJ;
                                ara=OJ.ara;

                                nc.write(s);
                                if(s.equals("sendproblem")) new ClientProblemReadThread(nc,ara);
                                if(s.equals("newUser")) {nc.write(main.username);nc.closeConnection();}
                                if(s.equals("sendStandings")) new ClientStandingReadThread(nc,main.user);
                                if(s.equals("sendStatus")) new ClientStatusReadThread(nc,main.statuses);
                            } catch(Exception e) {
                                System.out.println (e);
                            }
	}
                  
                  public void setFile(File fp,int prob_num){
                      this.fp=fp;
                      new ClientSubmissionWriteThread(nc,fp,main,prob_num);
                  }
}

