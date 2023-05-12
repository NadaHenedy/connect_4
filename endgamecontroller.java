package application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class endgamecontroller {
	@FXML
    private Text goodLuckText;// text at the end of game 
    @FXML
    private Text pScore;// player score
    @FXML
    private Text aScore;// computer score
    @FXML
    private AnchorPane pane;// to size of the score externally
    // to initialize board
    public void initialize(){
        pScore.setText(""+ Main.scores[0]);// to print the score of player
        aScore.setText(""+ Main.scores[1]);// to print the score of computer
        String message;
        if(Main.scores[0] > Main.scores[1]){// if the score of player is greater than the score of ai
        	message = "Congratulations"; // print this message
            pane.setStyle("-fx-background-color: #7FFF00");// set
        }else if (Main.scores[0] == Main.scores[1]){// if the score of player id equal to the score of ai
        	message = "Draw";// print draw message
            pane.setStyle("-fx-background-color: #FFD700");
        }else{// if the score of player is less than the score of ai
        	message = "Lost";// print lost message
            pane.setStyle("-fx-background-color: #FF0000");
        }
        goodLuckText.setText(message);// print this text in good luck text 
    }
    @FXML
    private void ok(Event event){
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();// to get the scene of the player
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
