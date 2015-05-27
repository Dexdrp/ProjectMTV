package view;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class MainPanel extends GridPane{
	
	private static MainPanel instance;
	
	private NotificationSliderPanel notificationSliderPanel = new NotificationSliderPanel();
	private QueueListPanel notificationStackPanel = new QueueListPanel();
	
	private QuestionListPanel questionPanel = new QuestionListPanel();
	
	private MainPanel(){
		
		new Text();
		
		setId("main-panel");
		
		ColumnConstraints column;
		RowConstraints row;
		
		column = new ColumnConstraints();
		column.setPrefWidth(400);
		column.setMinWidth(400);
		//column.setPercentWidth(25);
		getColumnConstraints().add(column);
		
		column = new ColumnConstraints();
		column.setHgrow(Priority.ALWAYS);
		getColumnConstraints().add(column);
		
		row = new RowConstraints();
		row.setPrefHeight(200);
		row.setMinHeight(200);
		getRowConstraints().add(row);
		
		row = new RowConstraints();
		row.setVgrow(Priority.ALWAYS);
		getRowConstraints().add(row);
		
		add(notificationSliderPanel, 0, 0, 2, 1);
		add(notificationStackPanel, 0, 1, 1, 1);
		add(questionPanel, 1, 1, 1, 1);
		
	}
	
//	public void addQuestion(Question question){
//		QuestionPanel panel = new QuestionPanel();
//		panel.setQuestion(question);
//		getChildren().add(panel);
//	}
	
	public static MainPanel getInstance(){
		if(instance == null){
			instance = new MainPanel();
		}
		return instance;
	}

}