/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientFX;

import ClientNetworking.Client;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import online.judge.UserOnlineJudge;

/**
 *
 * @author Aspire
 */
public class LogInController implements Initializable {
    
    UserOnlineJudge main;
    
    @FXML
    private TextField iTextField;
    @FXML
    private Text iNewUser;
    @FXML
    private Button iSignup;
    @FXML
    private GridPane IGrid;
    private PasswordField iPasswordField;
    @FXML
    private TextField iUser;
    @FXML
    private PasswordField iPassword;
    
    @FXML
    private void bHome(ActionEvent event) throws IOException {
        main.username=iUser.getText();
        new Client(main,"newUser");
        main.showHomePage(); 
    } 
    
    
    @FXML
    private void bRegister(ActionEvent event)throws IOException{
        main.showRegister();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    public void setMain(UserOnlineJudge scene){
        main=scene;
        
    } 
    
}
