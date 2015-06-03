package view;

import view.notification.NotificationPanel;
import view.question.QuestionListPanel;
import view.queue.QueueListPanel;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class MainPanel extends GridPane{
	
	private static MainPanel instance;
	
	private NotificationPanel notificationSliderPanel = new NotificationPanel();
	private QueueListPanel queueListPanel = QueueListPanel.getInstance();
	private QuestionListPanel questionListPanel = QuestionListPanel.getInstance();
	
	private MainPanel(){
		
		new Text();
		
		setId("main-panel");
		
		ColumnConstraints column;
		RowConstraints row;
		
		column = new ColumnConstraints(); // Column 1, column for queue & part of the notifications.
		column.setMinWidth(300);
		column.setPrefWidth(300);
		column.setMaxWidth(300);
		getColumnConstraints().add(column);
		
		column = new ColumnConstraints(); // Column 2, column for questions & part of the notifications.
		column.setHgrow(Priority.ALWAYS);
		getColumnConstraints().add(column);
		
		row = new RowConstraints(); //Row 1, row for the notifications.
		row.setMinHeight(200);
		row.setPrefHeight(200);
		row.setMaxHeight(200);
		getRowConstraints().add(row);
		
		row = new RowConstraints(); // Row 2, row for the queue & questions.
		row.setVgrow(Priority.ALWAYS);
		getRowConstraints().add(row);
		
		add(notificationSliderPanel, 0, 0, 2, 1);
		add(queueListPanel, 0, 1, 1, 1);
		add(questionListPanel, 1, 1, 1, 1);
		
	}
	
	public static MainPanel getInstance(){
		if(instance == null){
			instance = new MainPanel();
		}
		return instance;
	}

}