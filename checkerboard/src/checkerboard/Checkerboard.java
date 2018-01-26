/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author joewong
 */
public class Checkerboard extends Application {
    
    private AnchorPane board;
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private double rectWidth;
    private double rectHeight;
    
//    private final Color[] colors = {Color.RED, Color.BLACK, Color.SKYBLUE, Color.DARKBLUE};
    private Color lightColor;
    private Color darkColor;
    
    public Checkerboard(){
        this(8,8,600.0,600.0);
    }
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight){
        this(numRows, numCols, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        this.rectWidth = Math.ceil(boardWidth / numCols);
        this.rectHeight = Math.ceil(boardHeight / numRows);
    }
    
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
    
    /**
     * Dynamically add rectangles to an existing AnchorPane
     * @param board
     * @return AnchorPane
     */
    public AnchorPane build(AnchorPane board){
        for(int row = 0; row < numRows; row++){
            for(int col = 0; col < numCols; col++){
                Color color = (row + col)%2 == 0? lightColor : darkColor;
                Rectangle rect = new Rectangle(rectWidth, rectHeight, color);
                
                board.getChildren().add(rect);
                AnchorPane.setLeftAnchor(rect, rectWidth * col);
                AnchorPane.setTopAnchor(rect, rectHeight * row);
            }
        }
        return board;
    }
    
    /**
     * Build a brand new AnchorPane.
     * @return AnchorPane
     */
    public AnchorPane build(){
        
        board = new AnchorPane();
        
        for(int row = 0; row < numRows; row++){
            for(int col = 0; col < numCols; col++){
                Color color = (row + col)%2 == 0? lightColor : darkColor;
                Rectangle rect = new Rectangle(rectWidth, rectHeight, color);
                
                board.getChildren().add(rect);
                AnchorPane.setLeftAnchor(rect, rectWidth * col);
                AnchorPane.setTopAnchor(rect, rectHeight * row);
            }
        }
        
        return board;
    }
    
    public int getNumRows(){
        return numRows;
    }
    
    public int getNumCols(){
        return numCols;
    }
    
    public double getBoardWidth(){
        return boardWidth;
    }
    
    public double getBoardHeight(){
        return boardHeight;
    }
    
    public double getRectangleWidth(){
        return rectWidth;
    }
    
    public double getRectangleHeight(){
        return rectHeight;
    }
    
    public Color getLightColor(){
        return lightColor;
    }
    
    public Color getDarkColor(){
        return darkColor;
    }
    
    public AnchorPane getBoard(){
        return board;
    }
}
