package com.sample.counter;

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
