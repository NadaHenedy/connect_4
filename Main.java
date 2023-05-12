package application;
	

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import Algorithm.Algorithm;
import Algorithm.AlphaBeta;
import Algorithm.MinMax;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	public static Stage stage;// to host the scene of play 
    public static Algorithm solver;// to solve the Algorithm that will be choosen 
 
    public static Scene[] loadedScenes;// to load the scene of current play 
	public static int[] scores;// to show the scores of play
	public static boolean printTheTree;// to print the tree of Algorithm
	
	@Override
	// start of game
	public void start(Stage primaryStage) {
        loadedScenes = new Scene[2];// to load the 2 scenes of play  the start and the current 
		scores = new int[2];// the size of score will be 2 because they are 2 players
		scores[0] = 0;// will initialize the score of first player by 0
		scores[1] = 0;//will initialize the score of second player by 0
        Main.stage = primaryStage;// initialize the start of play  
		try {
			Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));// to load the root of tree from the mainScene 
			Scene scene = new Scene(root);// to start the scene of play from root
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());// to get the shape of connect 4 and extract it to appear
            loadedScenes[0] = scene;// to load the scene of the start 
            primaryStage.setScene(scene);// to set the primary Stage with the current scene
			primaryStage.setResizable(false);// to set the primary stage as it is not resizable 
			primaryStage.show();// to show the board 
            loadedScenes[1] = new Scene(FXMLLoader.load(getClass().getResource("gameScene.fxml")));// to load the scene that will change while playing from game scene 
		} catch(Exception e) {
			e.printStackTrace();// to print the place that error occurs 
		}
        
	}
	public static void main(String[] args) {
		launch(args);// to run the application
	}
	}
