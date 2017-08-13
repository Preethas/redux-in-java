package com.sample.counter;

public class CounterReducer {
	
	public CounterState getNextState(CounterState state, Action action) {
		CounterState newState = new CounterState(state.getVal());
		switch(action){
		 case INCREMENT:
			 newState.increment();
			 break;
		 case DECREMENT:
			 newState.decrement();
			 break;
		}
		return newState;
	}

}
