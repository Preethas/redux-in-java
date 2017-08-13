package com.sample.todo;

import java.io.Serializable;

public class ToDo implements Serializable{
	
	int id;
	boolean complete;
	String text;

	
	
	public ToDo(int id ,String text,boolean isComplete){
		this.text = text;
		this.complete = isComplete;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean isComplete) {
		this.complete = isComplete;
	}
	
	public boolean equals(Object o){
		// If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }
        if (!(o instanceof ToDo)) {
            return false;
        }
        // typecast o to Complex so that we can compare data members 
        ToDo todo = (ToDo) o;
         
        // Compare the data members and return accordingly 
        return this.id == todo.id;
	}
	
	public String toString(){
		String output = String.format("%s = %d,%s = %s, %s = %s", "ID", id,"TEXT",text,"COMPLETE",complete);
		return "{" + output + "}";
	}

}
