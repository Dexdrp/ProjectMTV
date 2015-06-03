package view.question;

import java.util.ArrayList;

import model.Question;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class QuestionListPanel extends StackPane{
	
	private static QuestionListPanel instance;
	
	private final static int rowAmount = 8;
	
	private ArrayList<QuestionComponent> array = new ArrayList<QuestionComponent>();
	private VBox questionList = new VBox();
	
	private QuestionListPanel(){
		
		setId("question-list");
		
		questionList.setSpacing(3);
		
		getChildren().add(questionList);
		
	}
	
	public void update(){
		
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