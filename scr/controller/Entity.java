package controller;

import java.io.Serializable;

public class Entity implements Serializable{

	private static final long serialVersionUID = -7940898331284838487L;
	
	private Object o;
	private ENTITY_TYPE type;

	public Entity(ENTITY_TYPE type, String message) {
		this.type = type;
		this.o = message;
	}
	 
	public Entity(ENTITY_TYPE type, int updateIndex) {
		this.type = type;
		this.o = updateIndex;
	}

	public Object getO() {
		return o;
	}

	public ENTITY_TYPE getType() {
		return type;
	}
}
