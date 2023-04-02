/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientFX;

import java.awt.TextArea;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import online.judge.UserOnlineJudge;
import online.judge.Stands;

class InfoComparator implements Comparator<Stands> {
     public int compare(Stands self, Stands other) {
        // I'm assuming your Employee.id is an Integer not an int.
        // If you'd like to use int, create an Integer before calling compareTo.
        return (new Integer(other.point)).compareTo(new Integer(self.point));
    }
}



public class UserStandingsController implements Initializable {
    UserOnlineJudge main;
    @FXML
    private AnchorPane Pane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
  
    public void setStandings(){
        GridPane Standings=new GridPane();
        Standings.setLayoutX(175);
        Standings.setLayoutY(200);
        Pane.getChildren().add(Standings);
        
        TextField p1=new TextField("Username");
        TextField p2=new TextField("Point");
        
        p1.setAlignment(Pos.CENTER);
        p2.setAlignment(Pos.CENTER);
        p1.setStyle("-fx-font: 18 arial;");
        p2.setStyle("-fx-font: 18 arial;");
        
        Standings.add(p1, 0,1);
        Standings.add(p2, 1,1);
        Collections.sort(main.user,new InfoComparator());
        
        for(int i=0;i<main.user.size();i++){
           System.out.println(i);
            RowConstraints row=new RowConstraints(40);
            Standings.getRowConstraints().add(row);
            
            TextField t1=new TextField(main.user.get(i).name);
            TextField t2=new TextField(String.valueOf(main.user.get(i).point));
            t1.setAlignment(Pos.CENTER);
            t2.setAlignment(Pos.CENTER);
            
            t1.setStyle("-fx-font: 18 arial;");
            t2.setStyle("-fx-font: 18 arial;");
             
            Standings.add(t1, 0,i+2);
            Standings.add(t2, 1,i+2);
        }
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
    
    public void setMain(UserOnlineJudge p){
        main=p;
    }
    
}
