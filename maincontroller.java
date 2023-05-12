package application;

import Algorithm.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
public class maincontroller {
	@FXML
    private TextField maxDepthField;// allow user to enter the maximum depth
    @FXML
    private Text onlyDigitsWarning;// to prevent the user to enter anything except digits
    @FXML
    private RadioButton miniMaxButton;// to make a button to choose the minimax method
    @FXML
    private CheckBox printTheTreeBox;// check box if the user want to print  the tree of method he choose
	@FXML
    private void start(){// to start the game
        int maxDepth;// maximum depth that user will enter
        try{
            maxDepth = Integer.parseInt(maxDepthField.getText());// to get the maximum depth as an input from user
        }catch(NumberFormatException e){
            onlyDigitsWarning.setVisible(true); // warning if he doesn't enter digit and make it visible to user
            return;
        }
        onlyDigitsWarning.setVisible(false);// if he enters correctly then don't appear the warning
        if(miniMaxButton.isSelected())// if he choose the minimax method and click to the button of it
            Main.solver =  new MinMax(maxDepth);// then call the method from algorithm and give it the maximum depth
        else
            Main.solver =  new AlphaBeta(maxDepth);// if he choose the AlphaBeta method then call the method from algorithm and give it the maximum depth
        maxDepthField.clear();// to clear the text from value
        Main.printTheTree = printTheTreeBox.isSelected();// to print tree if he choose to print the tree
        printTheTreeBox.setSelected(false);// if he doesn't select to print tree 
        Main.stage.setScene(Main.loadedScenes[1]);// to load the last scene of play 
    }

    @FXML
    private void exit(){
        System.exit(0);// to exit the whole play
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
