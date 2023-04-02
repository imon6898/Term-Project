package ClientFX;

import ClientNetworking.Client;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import online.judge.UserOnlineJudge;

public class UserContestPageController implements Initializable {
    UserOnlineJudge main;
    @FXML
    private AnchorPane mainPane;
    int button_num=0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void setProb() throws IOException{
        System.out.println(main.ara.size());
         for(int i=0;i<main.ara.size();i++){
            File fp=main.ara.get(i);
            
           Button b =  makeButton(button_num, fp);        
           mainPane.getChildren().add(b);
           button_num++;
        }
    }
    

    
    public Button makeButton(int button_num,File fp){
         char ch = (char) (button_num+'A');
         Button b= new Button("Problem  :  "+ch); 
         b.setLayoutX(200);
         b.setLayoutY(250+button_num*60);
         b.setPrefSize(200,30);
         
         
         b.setStyle("-fx-font: 18 System; -fx-base: #009900;");
            
         b.setOnAction(e->{
             if(fp!=null) try {
                 main.showProb(fp,button_num);
             } catch (IOException ex) {
                 Logger.getLogger(UserContestPageController.class.getName()).log(Level.SEVERE, null, ex);
             }
           }
         );
         return b;
    }
    
    public void bContestPage() throws IOException, InterruptedException{
        main.showUserContestPage();
    }
    
    public void showHome() throws IOException{
        main.showHomePage();
    }
    
    public void showUserStandings() throws IOException, InterruptedException{
        main.showUserStandingsPage();
    }
    
    public void showUserStatus() throws IOException, InterruptedException{
        main.showUserStatusPage();
    }
    
    public void setMain(UserOnlineJudge scene){
        main=scene;
    }
    
}
