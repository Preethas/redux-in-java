package com.sample.todo;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Test;

public class ToDoTest {

	@Test
	public void testAddTodo() {
		ToDoMain todomain = new ToDoMain();
		IntStream.range(0, 5).forEach(i -> todomain.addToDo(new ToDo(1,i + "-todo",false))); 
		assertEquals(todomain.getToDoList().size(),5);
	}
	
	@Test
	public void testRemoveTodo() {
		ToDoMain todomain = new ToDoMain();
		IntStream.range(0, 5).forEach(i -> todomain.addToDo(new ToDo(i,i + "-todo",false)));
		assertEquals(todomain.getToDoList().size(),5);
		
		IntStream.range(0, 5).forEach(i -> todomain.removeToDo(new ToDo(i,i + "-todo",false)));
		assertEquals(todomain.getToDoList().size(),0);
	}
	
    @Test
	public void testToggleTodo() {
		ToDoMain todomain = new ToDoMain();
		ToDo newtoDo = new ToDo(1,1 + "-todo",false);
		todomain.addToDo(newtoDo);
		todomain.toggleToDo(newtoDo);
		assertEquals(todomain.getToDoList().get(0).isComplete(),!newtoDo.isComplete());
	}
	
    @Test
	public void testVisibilityFilter() {
		ToDoMain todomain = new ToDoMain();
		ToDo newtoDo = new ToDo(1,1 + "-todo",false);
		todomain.addToDo(newtoDo);
		todomain.showList();
		assertEquals(todomain.isVisible(),true);
	}

}
