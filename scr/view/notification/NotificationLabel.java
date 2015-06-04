package view.notification;

import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class NotificationLabel extends Group{
	
	private double w, h;
	
	private Rectangle clip;
	public Text text;
	
	public NotificationLabel(String string) {
		
		clip = new Rectangle(100, 100);
		text = new Text(string);
		
		text.setTextAlignment(TextAlignment.CENTER);
		text.setTextOrigin(VPos.CENTER);
		text.setFont(new Font("Calibri", 42));
		
		text.setClip(clip);
		
		getChildren().add(text);
		
	}
	
	public void doLayout() {
		super.layoutChildren();
		
		clip.setWidth(w);
		clip.setHeight(h);
		clip.setLayoutX(0);
		clip.setLayoutY(-h/2);
		
		text.setWrappingWidth(w);
		text.setLayoutX(w / 2 - w / 2);
		text.setLayoutY(h / 2);
		
	}
	
	public void setWidth(double width){
		w = width;
	}
	
	public void setHeight(double height){
		h = height;
	}
	
	public void setText(String string){
		text.setText(string);
	}

}