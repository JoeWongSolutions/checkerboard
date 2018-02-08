/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author joewong
 */
public class CheckerboardMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("checkerboardFXML.fxml"));
        Parent root = (Parent)loader.load();
        checkerboardFXMLController boardController = loader.getController();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        System.out.println("About to start");
        boardController.start(stage);    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
