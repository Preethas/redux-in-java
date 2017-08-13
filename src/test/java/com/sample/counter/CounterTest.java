package com.sample.counter;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Test;

public class CounterTest {

	@Test
	public void testIncrement() {
		CounterMain main = new CounterMain();
		IntStream.range(0, 5).forEach(i -> main.increment()); 
		assertEquals(main.getValue(),5);
	}
	
	@Test
	public void testDecrement() {
		CounterMain main = new CounterMain();
		IntStream.range(0, 5).forEach(i -> main.increment()); 
		assertEquals(main.getValue(),5);
		IntStream.range(0, 5).forEach(i -> main.decrement()); 
		assertEquals(main.getValue(),0);
	}

}
