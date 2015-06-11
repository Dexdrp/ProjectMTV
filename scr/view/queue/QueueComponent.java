package view.queue;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class QueueComponent extends GridPane{
	
	public QueueComponent(){
		
		ListView<String> list = new ListView<>();
		Label label = new Label("Derp");
		
		StackPane container1 = new StackPane();
		
		container1.getChildren().add(label);
		
	}

}