package view.question;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class TagHolderPanel extends FlowPane{
	
	public TagHolderPanel(){
		
		setId("tags-panel");
		
		setMinWidth(0);
		
	}
	
	public void addTag(String tag){
		
		Label label = new Label(tag);
		label.getStyleClass().add("tag");
		
		getChildren().add(label);
		
	}
	
	public void clearTags(){
		
		for(Node tag : getChildren()){
			clearConstraints(tag);
		}
		
	}

}
