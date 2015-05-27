package datalayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Notification;
import model.Question;

public class DaoTVView extends DaoConnection {
	
	private static DaoTVView instance;
	
	public boolean getNotifications(){
		
		try {
			
			openConn();
			
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM mededeling";
			
			ResultSet rs = statement.executeQuery(query);
			
			ArrayList<Notification> notifications = new ArrayList<Notification>();
			while(rs.next()){
				
				Notification notification = new Notification(
					rs.getInt("mededeling_id"),
					rs.getString("begindatum"),
					rs.getString("einddatum"),
					rs.getString("naam"),
					rs.getString("beschrijving")
				);
				notifications.add(notification);
				
			}
			
			// TODO: Do stuff with the notifications...
			
			conn.close();
			
			return true;
		} catch (SQLException e) {
			//new DataLogger(e);
            closeConn();
            return false;
		}
		
	}
	
	public boolean getQuestions(){
		
		try {
			
			openConn();
			
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM `question-tmp`";
			
			ResultSet rs = statement.executeQuery(query);
			
			ArrayList<Question> questions = new ArrayList<Question>();
			while(rs.next()){
				
				String tagsString = rs.getString("tags");
				String[] tags = tagsString.split("\\;");
				
				Question question = new Question(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("description"),
					rs.getInt("answers"),
					tags
				);
				questions.add(question);
				
			}
			
//			for(Question question : questions){
//				MainPanel.getInstance().addQuestion(question);
//			}
			
			conn.close();
			
			return true;
		} catch (SQLException e) {
			//new DataLogger(e);
            closeConn();
            return false;
		}
		
	}
	
	public static DaoTVView getInstance(){
		if(instance == null){
			instance = new DaoTVView();
		}
		return instance;
	}

}
