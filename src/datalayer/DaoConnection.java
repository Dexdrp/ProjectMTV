package datalayer;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class DaoConnection {
	
	private String url = "jdbc:mysql://martcor.nl:3306/deb42181_prom";
	private String user = "deb42181_prom";
	private String password = "Vgj7KtOj";
	
	protected Connection conn;
	protected Statement stmt;
	protected ResultSet rs;
	protected Boolean del;
	protected Boolean ins;
	protected PreparedStatement pst;
	
/* DaoConnection class: The purpose of this class is to open or close a connection to the database.
 * The database can be defined above by setting (or altering) the values.
 * 
 * NOTE: It is not permitted to add, remove or modify ANY of the methods in this class.
 * Only the private fields: String url;
 * 							String user;
 * 							String password;
 * may be altered to connect to a database.
 */
	
	public void openConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			setConn((Connection) DriverManager.getConnection(url, user,
					password));
		} catch (Exception e) {
			//new DataLogger(e);
			JOptionPane.showMessageDialog(null,"Connection failed, check the logs for more info.");
		}
	}
	
	public void closeConn() {
		try {
			conn.close();
		} catch (SQLException sql) {
			//new DataLogger(sql);
		}
	}
	
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
