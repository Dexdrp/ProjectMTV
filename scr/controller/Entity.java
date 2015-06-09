package controller;

import java.io.Serializable;

public class Entity implements Serializable{

	private static final long serialVersionUID = -7940898331284838487L;
	
	public final static int MESSAGE = 0;
	public final static int LIST_UPDATE = 1;
	
	private Object o;
	private int type;

	public Entity(int type, String message) {
		this.type = type;
		this.o = message;
	}
	 
	public Entity(int type, int updateIndex) {
		this.type = type;
		this.o = updateIndex;
	}

	public Object getO() {
		return o;
	}

	public int getType() {
		return type;
	}
}
