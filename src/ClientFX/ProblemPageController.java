/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientFX;

import ClientNetworking.Client;
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
import javafx.stage.FileChooser;
import online.judge.UserOnlineJudge;

/**
 * FXML Controller class
 *
 * @author Anik
 */
public class ProblemPageController implements Initializable {
    UserOnlineJudge main;
    @FXML
    private TextArea ProblemBox;
    @FXML
    private Label ProblemName;
    int problem;

  
    public void setFile(File fp,int prob_num) throws FileNotFoundException {
        
        problem=prob_num;
        char ch=(char)('A'+prob_num);
        ProblemName.setText("Problem : "+ch);
        Scanner sc = new Scanner(fp);
        String line;
        while(sc.hasNextLine()){
            line=sc.nextLine();
            ProblemBox.appendText(line+"\n");
        }
    }
    public void setMain(UserOnlineJudge p){
        main=p;
    }
    
    @FXML
    public void bSubmit(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File fp = fileChooser.showOpenDialog(main.mainstage);
        Client t=new Client(main,"submitproblem");
        t.setFile(fp,problem);
    }
    
    @FXML
    public void back() throws IOException, InterruptedException{
        main.showUserContestPage();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
