package model;

import java.sql.Timestamp;

public class Question {
	
	private int id; // Question unique ID
	
	private String firstname; // Firstname of the user.
	private String insertion; // Insertion of the user.
	private String lastname; // Lastname of the user.
	
	private Timestamp timestamp; // Will be sorted on date.
	private String title;
	private String description;
	private int answers;
	private String[] tags;
	
	public Question(int id, String firstname, String insertion, String lastname,
			int timestamp, String title, String description, int answers, String[] tags){
		this.id = id;
		this.firstname = firstname;
		this.insertion = insertion;
		this.lastname = lastname;
		this.timestamp = new Timestamp(timestamp);
		this.title = title;
		this.description = description;
		this.answers = answers;
		this.tags = tags;
	}

	public int getId() {
		return id;
	}
	
	public String getFullName(){
		if(insertion != ""){
			return firstname + " " + insertion + " " + lastname; 
		}
		return firstname + " " + lastname; 
	}
	
	public String getFirstname(){
		return firstname;
	}
	
	public String getInsertion(){
		return insertion;
	}
	
	public String getLastname(){
		return lastname;
	}
	
	public Timestamp getTimeStamp(){
		return timestamp;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getAnswers() {
		return answers;
	}
	
	public String[] getTags(){
		return tags;
	}
	
}
