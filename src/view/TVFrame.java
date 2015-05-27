package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TVFrame extends Application{
	
	private String style = "style/Default.css";
	
	private MainPanel mainPanel = MainPanel.getInstance();
	
	public void start(Stage stage) {
		
		stage.setTitle("Een prachtig machtig wereldwonderachtig (PMW) frame");
		
		Scene scene = new Scene(mainPanel, 300, 250);
		scene.getStylesheets().add(style);
		stage.setScene(scene);
		
		stage.setMinHeight(400);
		stage.setMinWidth(500);
		stage.setWidth(800);
		stage.setHeight(600);
		
		//DaoTVView.getInstance().getQuestions();
		
//		stage.setFullScreen(true);
		
		stage.show();
		
	}
	
	public static void main(String[] args){
		launch();
	}
	
}