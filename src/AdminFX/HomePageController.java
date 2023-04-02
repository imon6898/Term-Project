/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminFX;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import online.judge.AdminOnlineJudge;

/**
 * FXML Controller class
 *
 * @author Aspire
 */
public class HomePageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    AdminOnlineJudge main;
    private Label label;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        
    @FXML
    private void bLogIn(ActionEvent event) throws IOException {
        main.showLogIn();
    }
    
    public void bContestPage(ActionEvent event) throws IOException{
        //main.showUserContestPage();
    }
        
    public void setMain(AdminOnlineJudge scene){
        main=scene;
    } 
    
}
