package view.question;

import java.util.ArrayList;

import model.Question;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class QuestionListPanel extends StackPane{
	
	private static QuestionListPanel instance;
	
	private final static int rowAmount = 8;
	
	private Label noQuestionsLabel = new Label("Er zijn op dit moment geen vragen...");
	private ArrayList<QuestionComponent> array = new ArrayList<QuestionComponent>();
	private VBox questionList = new VBox();
	
	private QuestionListPanel(){
		
		setId("question-list");
		
		questionList.setSpacing(3);
		getChildren().add(questionList);
		
		noQuestionsLabel.setVisible(false);
		noQuestionsLabel.setFont(new Font("Calibri", 28));
		getChildren().add(noQuestionsLabel);
			
	}
	
	public void update(){
		
		if(array.size() == 0){
			noQuestionsLabel.setVisible(true);
			return;
		}
		
		noQuestionsLabel.setVisible(false);
		
		for(int i=0;i<array.size();i++){
			if(i >= rowAmount){ break; }
			questionList.getChildren().add(array.get(i));
		}
		
	}
	
	public void add(Question question){
		
		QuestionComponent component = new QuestionComponent(question);
		array.add(component);
	}
	
	public void clear(){
		array.clear();
		questionList.getChildren().clear();
	}
	
	public static QuestionListPanel getInstance(){
		if(instance == null){
			instance = new QuestionListPanel();
		}
		return instance;
	}
	
}