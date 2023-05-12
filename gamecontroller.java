package application;
import java.io.IOException;
import Util.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class gamecontroller {
	 @FXML
	    private Circle turnColor;// the color of the coins
	    @FXML
	    private Text turnName;// to print the turn of player who will play
	    @FXML
	    private HBox boardBox;// the layout of board 
	    private int width,height;// width and height of board
	    private boolean playerSuccess = false;// to initialize the success
	    private char[][] board;
	    private Color pColor = Color.rgb(230, 255, 7),// the color of coin of player
	                aColor = Color.rgb(198, 10, 10);// the color of coin of ai
	    private String pName = "Player",// to set the name
	                aName = "AI";// to set the name
	    public void initialize(){
	        width = boardBox.getChildren().size();// to set the rows of the board
	        height = ((VBox)boardBox.getChildren().get(0)).getChildren().size();// to set the coloums of board 
	        board = new char[height][width];// set the size of board
	        // to initialize board at the start of game as it is empty
	        for(int i=0; i<height; i++)
	            for(int j=0; j<width; j++)
	                board[i][j] = '_';
	        turnColor.setFill(pColor);// while starting play set that the node will be filled by player coin 
	        turnName.setText(pName);// turn the name to player name because it's turn
	    }
	    @FXML
	    private void selectColumn(Event event){// selecting coloum while playing
	        boolean notFound = true;// if coloum is full  
	        int w = boardBox.getChildren().indexOf(event.getSource());// the index of event 
	        int h;
	        for(h=height-1; h>=0; h--){
	            if(board[h][w] == '_'){// if there is a space in this index
	                notFound = false;// so there is space for player play in this coloum
	                board[h][w] = 'p';// so put in this index the coin of player
	                playerSuccess = true;// the success that the player put in this node
	                break;
	            }
	        }
	        // coloum is full
	        if(notFound){
	            playerSuccess = false;// player can't play in this coloum
	            return;
	        }
	        ((Circle)((VBox) event.getSource()).getChildren().get(h)).setFill(pColor);// fill this circle the player coin
	        turnColor.setFill(aColor);// turn the color to the ai coin
	        turnName.setText(aName);// turn the name to the ai name
	        event.consume();// to close the coloum because it is full
	    }
	    @FXML
	    private void aiTurn(){
	        if( ! playerSuccess)// if the player success is true 
	            return;
	        char[][] nextBoard = Main.solver.Decision(board, Main.printTheTree);// the ai will play according to the algorithm you choose and then will print the tree 
	        boolean found = false;// initialize if he doesn't found a place to put the coin
	        for(int i=0; i<height; i++){
	            for(int j=0; j<width; j++){
	                if(nextBoard[i][j] != board[i][j]){// if the circle in this index in next board not equal the circle in this index of the state board
	                    //  ai move
	                    VBox col = (VBox)boardBox.getChildren().get(j); // to put the coin in this coloum
	                    ((Circle)col.getChildren().get(i)).setFill(aColor);// fill the coloume with the coin of ai
	                    board = nextBoard;// update the board after the new move
	                    found = true;// he found a place to put the coin 
	                    break;
	                }
	            }
	            if(found)// if there is no place 
	                break;
	        }
	        turnColor.setFill(pColor);// it is the turn to player play 
	        turnName.setText(pName);// switch name to player name
	        playerSuccess = false; // the success of player will be flase
	        if(compare.isFull(board)){// if board is full
	            endOfGame();
	        }
	    }
	    private void endOfGame(){
	        heuristic h = new heuristic();
	        Main.scores[0] = h.playerscore(board);// the score of player
	        System.out.println("player score : "+  Main.scores[0] );// print the score
	        Main.scores[1] = h.Aiscore(board);// the score of ai
	        System.out.println( "AI score : "+Main.scores[1]);// print the score
	        try {
	            Parent root = FXMLLoader.load(getClass().getResource("endgame.fxml"));// to load the endgame shape for root
			    Scene scene = new Scene(root);// make it scene 
	            Stage winningStage = new Stage();// to host winning scene
	            winningStage.setScene(scene);// set the scene
	            winningStage.setResizable(false);// not resizable
	            winningStage.show();// to show the winning board
	        } catch (IOException e) {
	            System.out.println("Problem with endGameScene.fxml");// there is a problem in end game scene
	            System.out.println("Player: "+Main.scores[0]+"\nAI: "+ Main.scores[1]);// print only the scores
	            e.printStackTrace();// to print the place that error occurs
	        }
	    }
	   @FXML
	 private void backToMainMenu(){
	        for(int j=0; j<board[0].length; j++){
	            VBox column = (VBox)boardBox.getChildren().get(j);
	            for(int i=0; i<board.length; i++){
	                board[i][j] = '_';
	                ((Circle)column.getChildren().get(i)).setFill(Color.WHITE);
	            }
	        }
	        playerSuccess = false;// just to be safe
	        Main.stage.setScene(Main.loadedScenes[0]);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
}
