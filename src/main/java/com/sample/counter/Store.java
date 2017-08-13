package com.sample.counter;

import java.util.Observable;


public class Store extends Observable {
    
	CounterState state;
	CounterReducer reducer;
	
	public Store(CounterReducer reducer){
		this.reducer = reducer;
		this.state = new CounterState();
	}
	
	public CounterState getState(){
		return state;
	}
	
	public void dispatch(Action action){
		this.state = reducer.getNextState(this.state, action);
		setChanged();
		notifyObservers();
	}
}
