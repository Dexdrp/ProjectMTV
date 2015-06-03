package controller;

import datalayer.DaoTVView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class RefreshHandler implements EventHandler{
	
	private static int duration = 5;
	
	private Timeline timeline = new Timeline();
	private DaoTVView db = new DaoTVView();
	
	public RefreshHandler(){
		
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(duration), this));
		timeline.playFromStart();
		
		// Call it right away, so we don't have to wait 5 seconds.
		handle(null);
		
	}

	@Override
	public void handle(Event arg0) {
		
		// Get stuff.
		db.getQuestions();
		db.getNotifications();
		
	}

}
