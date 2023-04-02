package Compilor;
import java.io.*;
import java.util.Scanner;

/**
 * Created by Hasan on 6/9/2016.
 */
public class OutputThreadIt implements Runnable{
    BufferedWriter writer;
    OutputStreamWriter ow;
    File fp;

    public OutputThreadIt(OutputStream ous, File Fr){
        ow=new OutputStreamWriter(ous);
        writer=new BufferedWriter(ow);
        fp = Fr;
    }

    @Override
    public void run() {
        try {
            Scanner sc = new Scanner(fp);
            while(sc.hasNextLine()){
                String s=sc.nextLine();
                System.out.println(s);
                ow.write(s+"\n");
            }

            ow.flush();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
