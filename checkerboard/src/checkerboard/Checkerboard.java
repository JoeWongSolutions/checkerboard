/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author joewong
 */
public class Checkerboard {
    
    private AnchorPane board;
    private final int numRows;
    private final int numCols;
    private final double boardWidth;
    private final double boardHeight;
    private final double rectWidth;
    private final double rectHeight;
    
//    private final Color[] colors = {Color.RED, Color.BLACK, Color.SKYBLUE, Color.DARKBLUE};
    private final Color lightColor;
    private final Color darkColor;
    
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
        this.board = board;
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
