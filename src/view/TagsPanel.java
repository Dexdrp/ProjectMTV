package view;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class TagsPanel extends FlowPane{
	
	public TagsPanel(){
		
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
