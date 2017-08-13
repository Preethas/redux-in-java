package com.sample.todo;

public class Action {
	
	ActionType type;
	ToDo data;
	boolean visible;
	
	

	public Action(ActionType type,ToDo data){
		this.type = type;
		this.data = data;
	}
	
	public Action(ActionType type,boolean visible){
		this.type = type;
		this.visible = visible;
	}
	
	public ActionType getType() {
		return type;
	}
	
	public void setType(ActionType type) {
		this.type = type;
	}
	
	public ToDo getData() {
		return data;
	}
	
	public void setData(ToDo data) {
		this.data = data;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	

}
