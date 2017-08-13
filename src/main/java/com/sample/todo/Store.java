package com.sample.todo;

import java.util.List;
import java.util.Observable;


import com.sample.todo.Action;

public class Store extends Observable {
	ToDoState state;
	List<IReducer> reducerList;
	
	public Store(List<IReducer> reducerList) {
		this.reducerList = reducerList;
		this.state = new ToDoState();
	}
	
	public ToDoState getState(){
		return state;
	}
	
	public void dispatch(Action action) {
		ToDoState newState = null;
		ToDoState prevState = this.state;
		for (IReducer reducer : reducerList){
		 newState = reducer.getNextState(prevState, action);
		 prevState = ToDoState.copy(newState);
		}
		this.state = newState;
		setChanged();
		notifyObservers();
	}
}
