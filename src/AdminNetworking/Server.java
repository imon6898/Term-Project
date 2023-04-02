package AdminNetworking;

import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;

import online.judge.Stands;
import online.judge.AdminOnlineJudge;

public class Server {
	private ServerSocket ServSock;
	public int i = 1;
	public Hashtable<String, NetworkUtil> table;
                  AdminOnlineJudge main;
        
	public Server(AdminOnlineJudge OJ) {
                        System.out.println("Server Started");
                        main=OJ;
                        table = new Hashtable<>();
                        try {
                                ServSock = new ServerSocket(33333);
                                while (true) {
                                        Socket clientSock = ServSock.accept();
                                        NetworkUtil nc=new NetworkUtil(clientSock);
                                        String s = (String)nc.read();
                                        String p;
                                        
                                        if(s.equals("newUser")) {
                                                p= (String) nc.read();
                                                main.user.add(new Stands(p,0));
                                        }
                                        else if( s.equals("sendStatus")) new ServerStatusWriteThread(nc,main.statuses);
                                        else if(s.equals("sendproblem")) new ServerProblemWriteThread(nc,main.ara);
                                        else if(s.equals("submitproblem")) new ServerSubmissionReadThread(nc,main);
                                        else if(s.equals("sendStandings")) new ServerStandingsWriteThread(nc,main.user);
                                       
                                }
                        }catch(Exception e) {
                                System.out.println("Server starts:"+e);
                        }
	}

}


