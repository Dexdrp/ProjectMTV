package datalayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sun.security.jca.GetInstance;
import view.notification.NotificationPanel;
import view.question.QuestionListPanel;
import model.Question;

public class DaoTVView extends DaoConnection {

	private static DaoTVView instance;

	public boolean getQuestions(){

		try {

			openConn();

			Statement statement = conn.createStatement();
			String query = "CALL sp_get_questions()";
			ResultSet rs = statement.executeQuery(query);

			QuestionListPanel questionListPanel = QuestionListPanel.getInstance();
			questionListPanel.clear();

			while(rs.next()){

				String tagsString = rs.getString("tags");
				String[] tags = tagsString.split("\\;");

				Question question = new Question(
						rs.getInt("id"),
						rs.getString("firstname"),
						rs.getString("insertion"),
						rs.getString("lastname"),
						rs.getInt("timestamp"),
						rs.getString("title"),
						rs.getString("description"),
						rs.getInt("answers"),
						tags
						);

				questionListPanel.add(question);

			}

			questionListPanel.update();

			conn.close();

			return true;
		} catch (SQLException e) {
			//			new DataLogger(e);
			e.printStackTrace();
			closeConn();
			return false;
		}

	}

	public boolean getNotifications(){
System.out.println("dsada");
		Statement statement;
		try{

			openConn();

			statement = conn.createStatement(); 
			String query = "CALL sp_get_notifications()";
			ResultSet rs = statement.executeQuery(query);

			NotificationPanel.clear();

			while(rs.next()){
				String description = rs.getString("description");
				System.out.println(description);
				NotificationPanel.insert(description);
			}

			conn.close();

			return true;

		} catch (SQLException e) {
			//			new DataLogger(e);
			closeConn();
			return false;
		}

	}

	private String ip;


	public String LoadServerIP(){
		String sql = "SELECT ip_address FROM server";

		try{
			openConn();

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); 

			while(rs.next()) {
				ip = rs.getString("ip_address");
			}

			closeConn();
		}
		catch(SQLException sqle){
			closeConn();
		}
		return ip;
	}

	public static DaoTVView getInstance() {
		if (instance == null) {
			instance = new DaoTVView();
		}
		return instance;
	}

}


