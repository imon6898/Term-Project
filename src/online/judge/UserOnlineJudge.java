//User



package online.judge;
import ClientFX.HomePageController;
import ClientFX.LogInController;
import ClientFX.ProblemPageController;
import ClientFX.RegisterController;
import ClientFX.UserContestPageController;
import ClientFX.UserStandingsController;
import ClientFX.UserStatusPageController;
import ClientNetworking.Client;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class UserOnlineJudge extends Application {
    public Stage mainstage;
    public ArrayList<File>ara=new ArrayList<File>();
    public ArrayList<Stands>user=new ArrayList<Stands>();
    public ArrayList<Stats>statuses=new ArrayList<Stats>();
    public Client c=null;
    public String username;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
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
        loader.setLocation(getClass().getResource("/ClientFX/HomePage.fxml"));
        Parent root = loader.load();
        
        HomePageController controller=loader.getController();
        controller.setMain(this);
      
        Scene scene = new Scene(root);
        mainstage.setScene(scene);
        mainstage.show();
    }
    

    
    public void showLogIn() throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/ClientFX/LogIn.fxml"));
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
        loader.setLocation(getClass().getResource("/ClientFX/Register.fxml"));
        Parent root = loader.load();
        
        RegisterController controller=loader.getController();
        controller.setMain(this);
        
        Scene scene = new Scene(root);        
        mainstage.setTitle("Online Judge");
        mainstage.setScene(scene);
        mainstage.show();    
        
    }
    
    public void showProb(File fp, int prob_num) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/ClientFX/ProblemPage.fxml"));
        Parent root = loader.load();
        
        ProblemPageController controller=loader.getController();
        controller.setMain(this);
        controller.setFile(fp,prob_num);
        
        Scene scene = new Scene(root);        
        mainstage.setTitle("Online Judge");
        mainstage.setScene(scene);
        mainstage.show();    
    }
    
    public void showUserContestPage() throws IOException, InterruptedException{
        synchronized(this){new Client(this,"sendproblem");}
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/ClientFX/UserContestPage.fxml"));
        Parent root = loader.load();
        
        UserContestPageController controller=loader.getController();
        controller.setMain(this);
        Thread.sleep(100);
        synchronized(this){controller.setProb();}
        
        Scene scene = new Scene(root);        
        mainstage.setTitle("Online Judge");
        mainstage.setScene(scene);
        mainstage.show();    
    }
    
    public void showUserStandingsPage() throws IOException, InterruptedException{
        new Client(this,"sendStandings");
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/ClientFX/UserStandings.fxml"));
        Parent root = loader.load();
        
        UserStandingsController controller=loader.getController();
        controller.setMain(this);
        synchronized(this) {controller.setStandings();}
      
        Scene scene = new Scene(root);
        mainstage.setScene(scene);
        mainstage.show(); 
    }
    
   public void showUserStatusPage() throws IOException, InterruptedException{
        new Client(this,"sendStatus");
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/ClientFX/UserStatusPage.fxml"));
        Parent root = loader.load();
        
        UserStatusPageController controller=loader.getController();
        controller.setMain(this);
        synchronized(this) {controller.setStatus();}
      
        Scene scene = new Scene(root);
        mainstage.setScene(scene);
        mainstage.show(); 
        
    }
        
}
