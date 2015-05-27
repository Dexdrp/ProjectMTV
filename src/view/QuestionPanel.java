package view;

import model.Question;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class QuestionPanel extends GridPane{
	
	private Label titleLabel = new Label("");
	
	private Label answAmountLabel = new Label("0");
	private Label answTextLabel = new Label("Antwoorden");
	
	//private Label tagsLabel = new Label("[TAG]");
	private TagsPanel tagsPanel = new TagsPanel();
	private Label userLabel = new Label("By Giel95");
	
	public QuestionPanel(){
		
		setId("question-panel");
		
		StackPane container1 = new StackPane();
		StackPane container2 = new StackPane();
		StackPane container3 = new StackPane();
		GridPane container4 = new GridPane();
		
		container1.getStyleClass().add("answerAmount"); // TOP LEFT
		container2.getStyleClass().add("answerText"); // BOTTOM LEFT
		container3.getStyleClass().add("title"); // TOP RIGHT
		container4.getStyleClass().add("bottom-right"); // BOTTOM RIGHT
		
		//tagsLabel.getStyleClass().add("tags");
		userLabel.getStyleClass().add("user");
		
		ColumnConstraints column;
		RowConstraints row;

		column = new ColumnConstraints(90);
		getColumnConstraints().add(column);
		
		column = new ColumnConstraints();
		column.setHgrow(Priority.ALWAYS);
		getColumnConstraints().add(column);
		
		row = new RowConstraints(60);
		getRowConstraints().add(row);
		
		row = new RowConstraints();
		row.setVgrow(Priority.ALWAYS);
		getRowConstraints().add(row);
		
		titleLabel.setStyle("-fx-wrap-text: true;");
		
//		questionLbl.setTextFill(Color.web("#0076AA"));
//		answAmountLabel.setTextFill(Color.web("#444444"));
//		answTextLabel.setTextFill(Color.web("#444444"));
		
		container1.getChildren().add(answAmountLabel);
		container2.getChildren().add(answTextLabel);
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
		
	}
	
	public QuestionPanel(Question question){
		this();
		setQuestion(question);
	}
	
	public void setQuestion(Question question){
		
		titleLabel.setText(question.getTitle());
		answAmountLabel.setText("" + question.getAnswers());
		
		tagsPanel.clearTags();
		for(String tag : question.getTags()){
			tagsPanel.addTag(tag);
		}
		
	}
	
}
