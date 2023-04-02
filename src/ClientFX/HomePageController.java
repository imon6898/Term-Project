package ClientFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import online.judge.UserOnlineJudge;

public class HomePageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    UserOnlineJudge main;
    private Label label;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        
    @FXML
    private void bLogIn(ActionEvent event) throws IOException {
        main.showLogIn();
    }
    
    public void bContestPage(ActionEvent event) throws IOException, InterruptedException{
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
