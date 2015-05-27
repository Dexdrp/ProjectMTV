package view.derp;

import view.QuestionPanel;
import javafx.geometry.Insets;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ListCellFactory implements Callback<ListView<QuestionPanel>, ListCell<QuestionPanel>> {

        @Override 
        public ListCell<QuestionPanel> call(ListView<QuestionPanel> list) {
            return new ListCell<QuestionPanel>(){
            	
            	public void updateItem(QuestionPanel item, boolean empty) {
            		super.updateItem(item, empty);
            		
            		if(item != null){
            			this.setPadding(new Insets(0));
            			setGraphic(item);
            		}
            		
                }
            	
            };
        }

}
