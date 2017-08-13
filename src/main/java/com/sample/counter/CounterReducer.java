package com.sample.counter;

/**
 * A reducer is a pure function which gets the next state given the current state and an action.
 * It describes how the action transforms the state into another state
 * The only important thing is that the state cant be mutated , so we must create an return
 * a new state object
 * @author srinivasan
 *
 */
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
