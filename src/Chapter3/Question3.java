package Chapter3;
/**
 * Create a set of stacks that creates a new stack once a specific threshold is reached. Pop() and Push() should work as if its one big stack
 * Follow Up: create a popAtIndex(int index) method.
 */
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Question3 {
	ArrayList<StackItem> list;
	int thresh;
	
	public Question3(int max) {
		list = new ArrayList<>();
		list.add(new StackItem());
		thresh = max;
	}
	
	public Object push( Object o) {
		if ( list.get(list.size() - 1).size == thresh) {
			list.add(new StackItem());
		}
		list.get(list.size() -1).push(o);
		return o;
	}
	
	public Object pop() {
		if ( list.get(list.size() - 1).size == 0) {
			list.remove(list.size() -1);
		}
		
		Object val = list.get(list.size() - 1).pop();
		return val;
	}
	
	public Object popAtIndex(int index) {
		if ( index > -1 && index < list.size()) {
			if ( list.get(index).size > 0) {
				Object val = list.get(index).pop();
				return val;
			} else {
				list.remove(index);
				return null;
			}
				
		}
		return null;
	}
	
	
	private class StackItem extends Stack<Object>{
		int size;
		
		StackItem() {
			size = 0;
		}
		
		public Object push( Object o) {
			super.push(o);
			size++;
			return o;
		}
		
		public Object pop() {
			Object o = size == 0 ? null :  super.pop();
			if ( o != null ) size--;
			return o;
		}
		
	}
	
	public static void main( String[] args) {
		
		Question3 stackset = new Question3(2);
		stackset.push(2);
		stackset.push(2);
		stackset.push(2);
		System.out.println(stackset.popAtIndex(1));
	}

}
