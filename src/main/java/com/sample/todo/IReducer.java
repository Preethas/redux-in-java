package com.sample.todo;

public interface IReducer {
	public ToDoState getNextState(ToDoState state, Action action);
}
