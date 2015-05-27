package model;

public class Notification {
	
	private int id;
	private String startDate;
	private String endDate;
	private String name;
	private String description;
	
	public Notification(int id, String startDate, String endDate, String name, String description){
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
}