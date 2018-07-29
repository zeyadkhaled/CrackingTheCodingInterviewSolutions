package Chapter3;
import java.util.Stack;
/**
 * Question: Implement a Queue class using two stacks
 *
 */
public class Question4 {
	Stack pushStack;
	Stack popStack;
	
	public Question4() {
		pushStack = new Stack();
		popStack = new Stack();
	}
	
	public void enqueue(Object o) {
		pushStack.push(o);
	}
	
	public void shiftToPopStack() {
		if ( popStack.isEmpty()) {
			while ( !pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
	}
	
	public Object dequeue() {
		shiftToPopStack();
		return popStack.pop();
	}
	
	public Object peek() {
		shiftToPopStack();
		return popStack.peek();
	}
}
