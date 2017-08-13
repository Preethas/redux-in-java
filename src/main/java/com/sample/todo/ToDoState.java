package com.sample.todo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The state can be any type of object , It can contain arrays ,primitives and other objects
 * @author srinivasan
 *
 */
public class ToDoState implements Serializable{
	
	List<ToDo> toDoList;
	boolean visible;

	ToDoState(){
		toDoList = new ArrayList<ToDo>();
	}
	
	ToDoState(List<ToDo> toDoList,boolean isVisible){
		this.toDoList = toDoList;
		this.visible = isVisible;
	}
	
	ToDoState(List<ToDo> toDoList){
		this.toDoList = toDoList;
	}
	
	ToDoState(boolean isVisible){
		super();
		this.visible = isVisible;
	}
	
	public void addToDo(ToDo todo){
		this.toDoList.add(todo);
	}
	
	public static ToDoState copy(ToDoState todoState){
		return (ToDoState) ToDoState.deepClone(todoState);
	}
	
    public void removeToDo(ToDo todo){
    	this.toDoList.remove(todo);
	}
    
    public void toggleToDo(ToDo todo){
    	int index = toDoList.indexOf(todo);
    	ToDo toBeUpdated = toDoList.get(index);
    	toBeUpdated.setComplete(!todo.isComplete());
    	
    }
	
	public List<ToDo> getList(){
		return toDoList;
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public static Object deepClone(Object object) {
		   try {
		     ByteArrayOutputStream baos = new ByteArrayOutputStream();
		     ObjectOutputStream oos = new ObjectOutputStream(baos);
		     oos.writeObject(object);
		     ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		     ObjectInputStream ois = new ObjectInputStream(bais);
		     return ois.readObject();
		   }
		   catch (Exception e) {
		     e.printStackTrace();
		     return null;
		   }
		 
    }

}
