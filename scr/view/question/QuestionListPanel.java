package view.question;

import java.util.ArrayList;

import model.Question;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
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
	
    @Override
    protected double computePrefWidth(double height) {
        // here calculate prefWidth
        // include padding 
    	System.out.println("computePrefWidth");
        return super.computePrefWidth(height);
    }

    @Override
    protected double computePrefHeight(double width) {
        // here calculate prefHeight
        // include padding and other stuff
    	System.out.println("computePrefHeight");
        return super.computePrefHeight(width);
    }

    @Override
    protected void layoutChildren() {
    	System.out.println("LayoutChildren");
        int i = 0;
        for (Node node : getChildren()) {
            layoutInArea(node, i, i, getWidth(), getHeight(), 0.0d, HPos.LEFT, VPos.TOP);
            i += 40;
        }
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