package com.sample.todo;

public class VisibilityReducer implements IReducer{

	public ToDoState getNextState(ToDoState state, Action action) {
		ToDoState newState = ToDoState.copy(state);
		switch(action.getType()){
		 case SHOW:
			 newState.setVisible(true);
			 break;
		 case HIDE:
			 state.setVisible(false);
			 break;
		default:
			break;	
		}
		return newState;
	}
}
