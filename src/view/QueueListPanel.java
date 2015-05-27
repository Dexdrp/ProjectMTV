package view;

import view.derp.ListCellFactory;
import view.derp.SelectionModel;
import model.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

public class QueueListPanel extends StackPane{
	
	private ObservableList<QuestionPanel> data = FXCollections.observableArrayList();
	private ListView<QuestionPanel> list = new ListView<QuestionPanel>(data);
	
	public QueueListPanel(){
		
		//setId("question-list");
		
		getChildren().add(list);
		
		list.setBackground(null);
		list.setEditable(false);
		list.setSelectionModel(new SelectionModel());
		list.setCellFactory(new ListCellFactory());
		
		for(int i=0;i<10;i++){
			
			add(new QuestionPanel(new Question(0, "This is a title.", "This is a description.",
				999, new String[]{"urgent", "derp", "hello", "hi", "urgent", "derp", "hello",
					"hi", "urgent", "derp", "hello", "hi"})));
			
		}
		
	}
	
	public void add(QuestionPanel question){
		data.add(question);
	}

}
