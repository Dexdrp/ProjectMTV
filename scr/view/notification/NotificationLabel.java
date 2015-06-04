package view.notification;

import java.awt.Color;

import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class NotificationLabel extends Group{
	
	private Rectangle rectangle;
	private Rectangle clip;
	public Text text;
	
	public NotificationLabel(String string) {
		
		rectangle = new Rectangle(100, 100);
		clip = new Rectangle(100, 100);
		text = new Text(string);
		
		rectangle.setFill(javafx.scene.paint.Color.WHITE);
		
		text.setTextAlignment(TextAlignment.CENTER);
		text.setTextOrigin(VPos.CENTER);
		text.setFont(new Font("Calibri", 42));
		
		text.setClip(clip);
		
		getChildren().add(rectangle);
		getChildren().add(text);
		
	}
	
	public void doLayout() {
		super.layoutChildren();
		
		final double w = rectangle.getWidth();
		final double h = rectangle.getHeight();
		
		clip.setWidth(w);
		clip.setHeight(h);
		clip.prefWidth(w);
		clip.prefHeight(h);
		clip.setLayoutX(0);
		clip.setLayoutY(-h/2);
	      
		text.setWrappingWidth(w * 1);
		text.setLayoutX(w / 2 - w / 2);
		text.setLayoutY(h / 2);
		
	}
	
	public void setWidth(double width){
		rectangle.setWidth(width - 1);
	}
	
	public void setHeight(double height){
		rectangle.setHeight(height - 1);
	}
	
	public void setText(String string){
		text.setText(string);
	}

}