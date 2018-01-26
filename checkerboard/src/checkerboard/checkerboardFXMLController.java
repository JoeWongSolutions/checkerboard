/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author joewong
 */
public class checkerboardFXMLController implements Initializable {
    
    Checkerboard checkerboard;
    Stage stage;
    
    @FXML
    private VBox root;
    
    @FXML
    private AnchorPane board;
    
    @FXML
    private MenuBar menuBar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void start(Stage stage){
        this.stage = stage;
        checkerboard = new Checkerboard(8, 8, root.getWidth(), root.getHeight() - menuBar.getHeight());
        root.getChildren().add(checkerboard.build());
    }
}
