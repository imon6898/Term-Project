package Compilor;
import java.io.*;

/**
 * Created by Hasan on 6/9/2016.
 */
public class RunIt {
    String st;
    static File fp=null;
    static File fr=null;
    static File ft = null;
    static Checker ch = null;
    static int verdict = 0;
    
    public String output(File Input,File Output,String filename) throws IOException{
        fp=Input;
        ft=Output;
                
         int dot=filename.lastIndexOf(".");
         String fileExtension=filename.substring(dot+1);                    
        String filenameWithoutExt=filename.substring(0,dot);
        
        fr=new File(filenameWithoutExt+".txt");
        
         fr.createNewFile();

        try {
            if(fileExtension.equals("cpp") || fileExtension.equals("c")){
                runProcessJavac("g++ -o "+filenameWithoutExt+" "+filename);
                if(verdict!=0) return "Compilation Error";
                runProcessJava(filenameWithoutExt);
            }
            else if(fileExtension.equals("java")){
                 runProcessJavac("javac "+filename);
                if(verdict!=0) return "Compilation Error";
                runProcessJava("java "+filenameWithoutExt);
            }
            else {
                 return "Compilation Error";
            }
            Thread.sleep(1000);
             ch = new Checker();
             st = ch.Check(ft,fr);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    private static void printLines(String name, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(name + " " + line);
        }
    }

    private static void runProcessJavac(String command) throws Exception {
        System.out.println("Enters Compile");
        Process pro = Runtime.getRuntime().exec(command);

        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
        verdict = pro.exitValue();
    }
    private static void runProcessJava(String command) throws Exception {
        System.out.println("Enters Run");
        
        Process pro = Runtime.getRuntime().exec(command);
        new Thread(new InputThreadIt(pro.getInputStream(),fr)).start();
        new Thread(new OutputThreadIt(pro.getOutputStream(),fp)).start();
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
    }

//    public static void main(String[] args) throws IOException {
//        //fp=new File("InO.txt");
//        fr=new File("SecO.txt");
//        //ft = new File("OutO.txt");
//
//
//
//    }
}
