/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminFX;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import online.judge.AdminOnlineJudge;

/**
 * FXML Controller class
 *
 * @author Anik
 */
public class ProblemPageController implements Initializable {
    AdminOnlineJudge main;
    @FXML
    private TextArea ProblemBox;
    @FXML
    private Label ProblemName;

  
    public void setFile(File fp,int prob_num) throws FileNotFoundException {
        
        char ch=(char)('A'+prob_num);
        ProblemName.setText("Problem : "+ch);
        Scanner sc = new Scanner(fp);
        String line;
        while(sc.hasNextLine()){
            line=sc.nextLine();
            ProblemBox.appendText(line+"\n");
        }
    }
    public void setMain(AdminOnlineJudge p){
        main=p;
    }
    
    @FXML
    public void back() throws IOException{
        main.showContestProblemChoice();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
