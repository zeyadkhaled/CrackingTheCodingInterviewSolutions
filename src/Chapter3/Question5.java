package Chapter3;

import java.util.Stack;

/**
 * 
 *Question: Sort a stack by using only an extra stack
 */
public class Question5 {
	
	/**
	 * To sort in O(n^2) using this method:
	 * (1) You pop one element from the unsorted stack
	 * (2) If sorted stack isn't empty and its peek method returns an int more than unsorted poped element, then pop the peeked element
	 * (3) Once sorted peeked element is < unsorted poped element then add to the sorted stack
	 * (4) repeat untill you put element by element in the sorted stack until unsorted stack is empty
	 */
	public static Stack<Integer> sortStack(Stack<Integer> s) {
		Stack<Integer> extra = new Stack<>();
		while ( !s.isEmpty()) {
			int tmp = s.pop();
			while ( !extra.isEmpty() && extra.peek() > tmp) {
				s.push(extra.pop());
			}
			extra.push(tmp);
		}
		return extra;
	}
	
	public static void main( String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(4);
		stack.push(2);
		stack.push(9);
		stack.push(1);
		stack.push(5);
		System.out.println(sortStack(stack).toString());
	}
}
