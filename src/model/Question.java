package model;

public class Question {
	
	private int id;
	private String title;
	private String description;
	private int answers;
	private String[] tags;
	
	public Question(int id, String title, String description, int answers, String[] tags){
		this.id = id;
		this.title = title;
		this.description = description;
		this.answers = answers;
		this.tags = tags;
	}

	public int getId() {
		return id;
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
