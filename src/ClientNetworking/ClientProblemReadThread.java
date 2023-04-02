package ClientNetworking;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ClientProblemReadThread implements Runnable{
    private Thread thr;
	private NetworkUtil nc;
                  int prob_num=0;
                  FileWriter fw;
                  PrintWriter pw;
                  ArrayList<File>ara;

	public ClientProblemReadThread(NetworkUtil nc,ArrayList<File>ara) {
		this.nc = nc;
                                    this.ara=ara;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
                                    ara.clear();
		try {
                                            while(true) {
                                                    String s=(String)nc.read();
                                                    if(s.equals("#")){
                                                            char ch=(char) (prob_num+'A');
                                                            File file=new File(ch+".txt");
                                                            ara.add(file);
                                                            
                                                            prob_num++;
                                                            
                                                            if(!file.exists()){
                                                                file.createNewFile();
                                                            }
                                                            fw=new FileWriter(file.getAbsoluteFile());
                                                            pw=new PrintWriter(fw,true);                                                     
                                                    }
                                                    else{     
                                                          pw.println(s);
                                                    }
                                            }
		} catch(Exception e) {
			System.out.println (e);                        
		}
		nc.closeConnection();
	}
}



