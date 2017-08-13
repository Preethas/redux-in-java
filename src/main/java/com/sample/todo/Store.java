package com.sample.todo;

import java.util.List;
import java.util.Observable;


import com.sample.todo.Action;

public class Store extends Observable {
	ToDoState state;
	List<IReducer> reducerList;
	
	/**
	 * Store takes in a list of reducers 
	 * Assumption is that each reducer works on different parts of the State
	 * 
	 * @param reducerList
	 */
	public Store(List<IReducer> reducerList) {
		this.reducerList = reducerList;
		this.state = new ToDoState();
	}
	
	public ToDoState getState(){
		return state;
	}
	
	/**
	 * In the javascript implementation the State object has key/value pairs
	 * The combined reducer has the key and the reducer which will operate on this key
	 * The new state is obtained by combining the next states obtained by each reducer 
	 * Here the state passed to a  reducer is the "next state" of the previous reducer
	 * This works because reducers work on different pieces of the state.
	 * 
	 * @param action
	 */
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
