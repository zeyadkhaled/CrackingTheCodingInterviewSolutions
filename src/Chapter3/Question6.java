package Chapter3;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * Create an animal shelter using a FIFO with a method dequeue any that returns the oldest animal in the shelter
 * 
 */
public class Question6 {
	
	Queue dogs = new LinkedList();
	Queue cats = new LinkedList();
	int stamp = 0;
	
	public void enqueue(Animal a) {
		a.setOrder(stamp);
		stamp++;
		
		if ( a instanceof Cat) cats.add(a);
		else if ( a instanceof Dog) dogs.add(a);
	}
	
	public Animal dequeueAny() {
		if ( dogs.size() == 0) return (Animal)cats.poll();
		if ( cats.size() == 0) return (Animal)dogs.poll();
		
		if ( ((Animal) cats.peek()).isOlder((Animal) dogs.peek())) {
			return (Animal) cats.poll();
		}
		return (Animal) dogs.poll();
	}
	
	public class Animal{
		int order;
		String name;
		Animal( String name) {
			this.name = name;
		}
		void setOrder(int order) {
			this.order = order;
		}
		int getOrder() { return order;}
		boolean isOlder(Animal a) {
			if ( a.getOrder() > order) return true;
			return false;
		}
	}
	
	public class Cat extends Animal{
		Cat(String name) {
			super(name);
		}	
	}
	public class Dog extends Animal{
		Dog(String name) {
			super(name);
		}
		
	}

}
