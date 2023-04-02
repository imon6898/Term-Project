package Compilor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Checker {
    String ori;
    String sec;
    RunIt runs;
    public String Check(File OriFile,File SecFile) throws FileNotFoundException {
        Scanner sc = new Scanner(SecFile);
        String sec = "";
        while(sc.hasNextLine()){
            String s=sc.nextLine();
            sec+= s;
        }
        Scanner scn = new Scanner(OriFile);
        String ori ="";
        while(scn.hasNextLine()){
            String s=scn.nextLine();
            ori+= s;
        }

        System.out.println(ori);
        System.out.println(sec);
        
        if(ori.equals(sec)) return "Accepted";
        else return "Wrong Answer";
    }
}
