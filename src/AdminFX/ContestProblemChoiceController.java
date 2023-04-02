/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminFX;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import online.judge.AdminOnlineJudge;

/**
 * FXML Controller class
 *
 * @author Anik
 */
public class ContestProblemChoiceController implements Initializable {
    AdminOnlineJudge main;
    int button_num=0;
    int flag=0;
    @FXML
    private AnchorPane mainPane;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    
    @FXML
    public void setProb() throws IOException{
         for(int i=0;i<main.ara.size();i++){
            File fp=main.ara.get(i);
            
           Button b =  makeButton(button_num, fp,0);
           mainPane.getChildren().add(b);
           button_num++;
        }
    }
    
    public void bAddProb(ActionEvent event) throws IOException{
        if(flag!=0) return;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File fp = fileChooser.showOpenDialog(main.mainstage);
        File file = null;

        char ch = (char) (button_num+'A');
        if(fp!=null){
            file=new File(ch+".txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw=new FileWriter(file.getAbsoluteFile());
            PrintWriter pw=new PrintWriter(fw,true);

            Scanner sc = new Scanner(fp);
            String line;
            while(sc.hasNextLine()){
                line=sc.nextLine();
                pw.println(line);
            }        
        }
        
         main.ara.add(file);
         Button b = makeButton(button_num, fp,0);
                
         if(fp!=null){
            flag=1;
            mainPane.getChildren().add(b);
            
            Button in=makeButton(button_num,null,1);
            mainPane.getChildren().add(in);
            Button out=makeButton(button_num,null,2);
            mainPane.getChildren().add(out);
            
            button_num++;
        }
         
         
         
    }
    
    public Button makeButton(int button_num,File fp,int cont){
         if(cont==0){
                char ch = (char) (button_num+'A');
                Button b= new Button("Problem  :  "+ch); 
                b.setLayoutX(200);
                b.setLayoutY(250+button_num*60);
                b.setPrefSize(200,30);
                b.setStyle("-fx-font: 18 System; -fx-base: #009900;");

                b.setOnAction(e->{
                    if(fp!=null && flag==0) try {
                        main.showProb(fp,button_num);
                    } catch (IOException ex) {
                        Logger.getLogger(ContestProblemChoiceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                );
                return b;
         }
         
         else if(cont==1){
             Button b=new Button("Choose Input File");
             b.setLayoutX(450);
             b.setLayoutY(220+button_num*60);
             b.setPrefSize(150,30);
             b.setStyle("-fx-base: #99ff66;");

             b.setOnAction(e->{
                  FileChooser fileChooser = new FileChooser();
                  fileChooser.setTitle("Open Resource File");
                  File fin = fileChooser.showOpenDialog(main.mainstage);
                  if(fin!=null){
                        main.inAra.add(fin);
                        flag=2;
                        mainPane.getChildren().remove(b);
                  }
               }
            );
            return b;
         }
         
         else if(cont==2){
             Button b=new Button("Choose Output File");
             b.setLayoutX(450);
             b.setLayoutY(280+button_num*60);
             b.setPrefSize(150,30);
             b.setStyle("-fx-base: #99ff66;");

             
             b.setOnAction(e->{
                  FileChooser fileChooser = new FileChooser();
                  fileChooser.setTitle("Open Resource File");
                  File fout = fileChooser.showOpenDialog(main.mainstage);
                  if(fout!=null){
                        main.outAra.add(fout);
                        flag=0;
                        mainPane.getChildren().remove(b);
                  }
               }
             );
             return  b;
         }
         return null;
    }
   
    public void setMain(AdminOnlineJudge scene){
        main=scene;  
    }
    
}
