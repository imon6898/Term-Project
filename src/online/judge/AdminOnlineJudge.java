//Admin



package online.judge;

import AdminFX.ContestProblemChoiceController;
import AdminFX.HomeAdminController;
import AdminFX.HomePageController;
import AdminFX.LogInController;
import AdminFX.ProblemPageController;
import AdminFX.RegisterController;
import java.io.File;
import java.io.IOException;
import java.security.Provider.Service;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.Stage;


public class AdminOnlineJudge extends Application {
    public Stage mainstage;
    public ArrayList<File>ara;
    public ArrayList<File>inAra;
    public ArrayList<File>outAra;
    
    public ArrayList<Stands>user=new ArrayList<Stands>();
    public ArrayList<Stats>statuses= new ArrayList<Stats>();
    
    @Override
    public void start(Stage stage) throws Exception {
       // new JavaAudioPlaySoundExample();
        mainstage=stage;
        showLogIn(); 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

    
    public void showHomePage() throws IOException{
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/AdminFX/HomePage.fxml"));
        Parent root = loader.load();
        
        HomePageController controller=loader.getController();
        controller.setMain(this);
      
        Scene scene = new Scene(root);
        mainstage.setScene(scene);
        mainstage.show();
    }
    
    public void showHomeAdmin() throws IOException{
        ara=new ArrayList<File>();
        inAra=new ArrayList<File>();
        outAra=new ArrayList<File>();;
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/AdminFX/HomeAdmin.fxml"));
        Parent root = loader.load();
        
        HomeAdminController controller=loader.getController();
        controller.setMain(this);
      
        
        
        Scene scene = new Scene(root);
        mainstage.setScene(scene);
        mainstage.show();
    }
    
    public void showLogIn() throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/AdminFX/LogIn.fxml"));
        Parent root = loader.load();
        
        LogInController controller=loader.getController();
        controller.setMain(this);
        
        Scene scene = new Scene(root);  
   
        
        mainstage.setTitle("Online Judge");
        mainstage.setScene(scene);
        mainstage.show();
    }
    
    public void showRegister() throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/AdminFX/Register.fxml"));
        Parent root = loader.load();
        
        RegisterController controller=loader.getController();
        controller.setMain(this);
        
        Scene scene = new Scene(root);        
        mainstage.setTitle("Online Judge");
        mainstage.setScene(scene);
        mainstage.show();    
        
    }
    
    public void showContestProblemChoice() throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/AdminFX/ContestProblemChoice.fxml"));
        Parent root = loader.load();
        
        ContestProblemChoiceController controller=loader.getController();
        controller.setMain(this);
        controller.setProb();
        
        Scene scene = new Scene(root);        
        mainstage.setTitle("Online Judge");
        mainstage.setScene(scene);
        mainstage.show();    
    }
    
    public void showProb(File fp, int prob_num) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/AdminFX/ProblemPage.fxml"));
        Parent root = loader.load();
        
        ProblemPageController controller=loader.getController();
        controller.setMain(this);
        controller.setFile(fp,prob_num);
        
        Scene scene = new Scene(root);        
        mainstage.setTitle("Online Judge");
        mainstage.setScene(scene);
        mainstage.show();    
    }
        
}
