package view.queue;

import model.Question;
import view.question.QuestionComponent;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class QueueListPanel extends VBox{
	
	private static QueueListPanel instance;
	
	private QueueListPanel(){
		
		setId("queue-list");
		
		setMinWidth(0);
		
		
	}
	
	public static QueueListPanel getInstance(){
		if(instance == null){
			instance = new QueueListPanel();
		}
		return instance;
	}
	
}