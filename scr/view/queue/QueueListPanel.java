package view.queue;

import model.Question;
import view.question.QuestionComponent;
import javafx.scene.layout.VBox;

public class QueueListPanel extends VBox{
	
	private static QueueListPanel instance;
	
	private QueueListPanel(){
		
		setId("queue-list");
		
	}
	
	public void add(QuestionComponent questionComponent){
		getChildren().add(questionComponent);
	}
	
	public void add(Question question){
		add(new QuestionComponent(question));
	}
	
	public void remove(QuestionComponent questionPanel){
		getChildren().remove(questionPanel);
	}
	
	public void removeAll(){
		getChildren().clear();
	}
	
	public static QueueListPanel getInstance(){
		if(instance == null){
			instance = new QueueListPanel();
		}
		return instance;
	}
	
}