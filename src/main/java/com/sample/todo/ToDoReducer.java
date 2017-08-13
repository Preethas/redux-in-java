package com.sample.todo;

import com.sample.todo.Action;
import com.sample.todo.ToDoState;

/**
 * A reducer is a pure function which gets the next state given the current state and an action.
 * It describes how the action transforms the state into another state
 * The only important thing is that the state cant be mutated , so we must create an return
 * a new state object
 * @author srinivasan
 *
 */
public class ToDoReducer implements IReducer{

	public ToDoState getNextState(ToDoState state, Action action) {
		ToDoState newstate = ToDoState.copy(state);
		switch(action.getType()){
		 case ADD_TODO:
			 newstate.addToDo(action.getData());
			 break;
		 case REMOVE_TODO:
			 newstate.removeToDo(action.getData());
			 break;
		 case TOGGLE_TODO:
			 newstate.toggleToDo(action.getData());
			 break;		 
			 
		}
		return newstate;
	}
}
