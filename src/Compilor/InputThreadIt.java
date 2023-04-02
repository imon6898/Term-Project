package Compilor;
import java.io.*;
import java.util.Scanner;

/**
 * Created by Hasan on 6/9/2016.
 */
public class InputThreadIt implements Runnable {
    BufferedReader reader;
    File fr;
    FileWriter fw;
    PrintWriter pw;




    public InputThreadIt(InputStream ins, File fp) throws IOException {
        reader=new BufferedReader(new InputStreamReader(ins));
        fr = fp;
        fw = new FileWriter(fr);
        pw = new PrintWriter(fw);
    }

    @Override
    public void run() {
        String line =  null;


        try {

            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                pw.println(line+"\n");

            }
            pw.flush();
            pw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }



}
