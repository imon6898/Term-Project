package ClientFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import online.judge.UserOnlineJudge;

public class UserStatusPageController implements Initializable {
     UserOnlineJudge main;
    @FXML
    private AnchorPane Pane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setMain(UserOnlineJudge p){
        main=p;
    }
    
     @FXML
    public void showHome() throws IOException{
        main.showHomePage();
    }
    
     @FXML
    public void showUserStandings() throws IOException, InterruptedException{
        main.showUserStandingsPage();
    }
    
     @FXML
    public void bContestPage() throws IOException, InterruptedException{
        main.showUserContestPage();
    }
    
     @FXML
    public void showUserStatus() throws IOException, InterruptedException{
        main.showUserStatusPage();
    }

    public void setStatus() {
//          for(int i=0;i<main.statuses.size();i++){
//              Stats s=main.statuses.get(i);
//              s.print();
//          }
        GridPane Standings=new GridPane();
        Standings.setLayoutX(75);
        Standings.setLayoutY(200);
        Pane.getChildren().add(Standings);
        
        TextField p1=new TextField("Username");
        TextField p2=new TextField("Problem");
        TextField p3=new TextField("Verdict");
        
        p1.setAlignment(Pos.CENTER);
        p2.setAlignment(Pos.CENTER);
        p3.setAlignment(Pos.CENTER);
        
        p1.setStyle("-fx-font: 18 arial;");
        p2.setStyle("-fx-font: 18 arial;");
        p3.setStyle("-fx-font: 18 arial;");
        
        Standings.add(p1, 0,1);
        Standings.add(p2, 1,1);
        Standings.add(p3, 2,1);
        
        for(int i=main.statuses.size()-1;i>=0;i--){
           System.out.println(i);
            RowConstraints row=new RowConstraints(40);
            Standings.getRowConstraints().add(row);
            
            TextField t1=new TextField(main.statuses.get(i).username);
            TextField t2=new TextField("Problem "+(char)(main.statuses.get(i).Problem_no+'A'));
            TextField t3=new TextField(main.statuses.get(i).verdict);

            t1.setAlignment(Pos.CENTER);
            t2.setAlignment(Pos.CENTER);
            t3.setAlignment(Pos.CENTER);
            
            t1.setStyle("-fx-font: 14 arial;");
            t2.setStyle("-fx-font: 14 arial;");
            t3.setStyle("-fx-font: 14 arial;");

             
            Standings.add(t1, 0,main.statuses.size()+1-i);
            Standings.add(t2, 1,main.statuses.size()+1-i);
            Standings.add(t3, 2,main.statuses.size()+1-i);
        }


    }
}
