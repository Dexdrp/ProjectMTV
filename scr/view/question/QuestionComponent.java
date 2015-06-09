package view.question;

import model.Question;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class QuestionComponent extends GridPane{
	
	private Question question;
	
	private Label titleLabel = new Label("");
	private Label answerAmountLabel = new Label("0");
	private Label answerTextLabel = new Label("Antwoorden");
	private TagHolderPanel tagsPanel = new TagHolderPanel();
	private Label userLabel = new Label("By UNKNOWN");
	
	public QuestionComponent(){
		
		setId("question-panel");
		
		StackPane container1 = new StackPane();
		StackPane container2 = new StackPane();
		StackPane container3 = new StackPane();
		GridPane container4 = new GridPane();
		
		container1.getStyleClass().add("answerAmount"); // TOP LEFT
		container2.getStyleClass().add("answerText"); // BOTTOM LEFT
		container3.getStyleClass().add("title"); // TOP RIGHT
		container4.getStyleClass().add("bottom-right"); // BOTTOM RIGHT
		
		titleLabel.setWrapText(true);
		userLabel.getStyleClass().add("user");
		
		ColumnConstraints column;
		RowConstraints row;

		column = new ColumnConstraints(90);
		column.setHgrow(Priority.NEVER);
		getColumnConstraints().add(column);
		
		column = new ColumnConstraints();
		column.setHgrow(Priority.ALWAYS);
		getColumnConstraints().add(column);
		
		row = new RowConstraints(80);
		row.setVgrow(Priority.NEVER);
		getRowConstraints().add(row);
		
		row = new RowConstraints();
		row.setVgrow(Priority.NEVER);
		getRowConstraints().add(row);		
		
		container1.getChildren().add(answerAmountLabel);
		container2.getChildren().add(answerTextLabel);
		container3.getChildren().add(titleLabel);
		
		column = new ColumnConstraints();
		column.setHgrow(Priority.ALWAYS);
		container4.getColumnConstraints().add(column);
		
		column = new ColumnConstraints();
		container4.getColumnConstraints().add(column);
		
		row = new RowConstraints();
		container4.getRowConstraints().add(row);
		
		container4.add(tagsPanel, 0, 0);
		container4.add(userLabel, 1, 0);
		
		add(container1, 0, 0);
		add(container2, 0, 1);
		add(container3, 1, 0);
		add(container4, 1, 1);
		
		setMaxHeight(0); // Fixes the size thingy.
		
	}
	
	public QuestionComponent(Question question){
		this();
		setQuestion(question);
	}
	
	public void setQuestion(Question question){
		
		this.question = question;
		
		titleLabel.setText(question.getTitle());
		answerAmountLabel.setText("" + question.getAnswers());
		userLabel.setText("By " + question.getFullName());
		
		tagsPanel.clearTags();
		for(String tag : question.getTags()){
			if(tag != ""){			
				tagsPanel.addTag(tag);
			}
		}
		
	}
	
	public Question getQueston(){
		return question;
	}
	
}