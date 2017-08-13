package com.sample.counter;

import java.util.Observable;
import java.util.Observer;

public class CounterMain implements Observer{
	
	int value ;
	Store store;
	
	CounterMain(){
		store = new Store(new CounterReducer());
		store.addObserver(this);
	}
	
	public void decrement() {
		store.dispatch(Action.DECREMENT);
	}
	
	public int getValue() {
		return value;
	}
	
	public void increment() {
		store.dispatch(Action.INCREMENT);
	}

	public void update(Observable o, Object arg) {
		value = store.getState().getVal();
	}

}
