package com.sample.counter;

/**
 * The state can be any type of object , It can contain arrays ,primitives and other objects
 * @author srinivasan
 *
 */
public class CounterState {
	
	int val = 0;
	
	CounterState(){
	}
	
	CounterState(int val){
		this.val = val;
	}

	public int getVal() {
		return val;
	}
	
	public void decrement() {
		this.val --;
	}

	public void increment() {
		this.val ++;
	}
	

}
