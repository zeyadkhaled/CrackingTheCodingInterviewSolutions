package Chapter3;

import java.util.Stack;
/**
 * Implement a stack that keeps track of the min value inside the stack?
 * 
 * Solution: Used another stack as a property to keep track of the min value after each push and pop to the main stack
 */
public class Question2 extends Stack<Integer> {
	Stack<Integer> minStack;
	public Question2() {
		minStack = new Stack<>();
	}
	
	public void push(int value) {
		if ( value <= min()) 
			minStack.push(value);
		super.push(value);
	}
	
	public Integer pop() {
		int value = super.pop();
		if ( value == min()) 
			minStack.pop();
		return value;
	}
	
	public int min() {
		if ( minStack.isEmpty()) return Integer.MAX_VALUE;
		return minStack.peek();
	}

}
