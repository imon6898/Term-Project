/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminFX;

import AdminNetworking.Server;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import online.judge.AdminOnlineJudge;

/**
 * FXML Controller class
 *
 * @author Anik
 */
public class HomeAdminController implements Initializable {
    AdminOnlineJudge main;
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            start_server();
        } catch (IOException ex) {
            Logger.getLogger(HomeAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
        public void start_server() throws IOException{
        Service<Void> service = new Service() {
        @Override
        protected Task<Void> createTask() {
            return new Task<Void>(){
                @Override
                protected Void call() throws Exception {
                    new Server(main); 
                    return null;
                }
            };
        }
     };
        service.start();
    }
    
    @FXML
    private void bContestChoice(ActionEvent event) throws IOException{
        main.showContestProblemChoice();
    }
    
    @FXML
    private void bLogIn(ActionEvent event) throws IOException {
        main.showLogIn();
    }

    public void setMain(AdminOnlineJudge scene){
        main=scene;
    } 

    

    
}
