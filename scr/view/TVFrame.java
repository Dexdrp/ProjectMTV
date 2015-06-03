package view;

import controller.RefreshHandler;
import datalayer.DaoTVView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TVFrame extends Application{
	
	private String style = "style/Default.css";
	
	private MainPanel mainPanel = MainPanel.getInstance();
	
	public void start(Stage stage) {
		
		stage.setTitle("Een prachtig machtig wereldwonderachtig (PMW) frame");
		
		Scene scene = new Scene(mainPanel, 1200, 800);
		scene.getStylesheets().add(style);
		stage.setScene(scene);
		
//		stage.setFullScreen(true);
		
		stage.show();
		
	}
	
	@Override
	public void init() throws Exception {
		super.init();
		
		new RefreshHandler();
		
	}
	
	public static void start(){
		launch();
	}
	
}