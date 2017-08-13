package com.sample.todo;

import com.sample.todo.Action;
import com.sample.todo.ToDoState;

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
