package com.sample.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.sample.todo.Action;
import com.sample.todo.Store;

public class ToDoMain implements Observer{
	
    Store store;
    List<ToDo> toDoList;
    boolean visibilityFilter;

	ToDoMain(){
    	List<IReducer> reducerList = new ArrayList<IReducer>();
    	reducerList.add(new ToDoReducer());
    	reducerList.add(new VisibilityReducer());
		store = new Store(reducerList);
		store.addObserver(this);
	}
	
	public void addToDo(ToDo todo) {
		store.dispatch(new Action(ActionType.ADD_TODO,todo));
	}
	
	public List<ToDo> getToDoList() {
		return toDoList;
	}

	public boolean isVisible() {
		return visibilityFilter;
	}
	
	public void removeToDo(ToDo todo) {
	    store.dispatch(new Action(ActionType.REMOVE_TODO,todo));
	}
	
	public void toggleToDo(ToDo todo){
	    store.dispatch(new Action(ActionType.TOGGLE_TODO,todo));
	}
	
	public void showList(){
	    store.dispatch(new Action(ActionType.SHOW,true));
	}
	
	public void hideList(){
	    store.dispatch(new Action(ActionType.HIDE,true));
	}

	public void update(Observable o, Object arg) {
		toDoList = store.getState().getList();
		visibilityFilter = store.getState().isVisible();
	}
	
	public static void main(String[] args){
		ToDoMain todomain = new ToDoMain();
		todomain.addToDo(new ToDo(1,"First todo",false));
		todomain.showList();
	}

}
