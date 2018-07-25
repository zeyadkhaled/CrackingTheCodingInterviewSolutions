import java.util.HashSet;
import java.util.Stack;

public class Chapter2 {

	private class Node {
		int data;
		Node next;
		Node( int d) {
			data = d;
			next = null;
		}
	}
	
	/**
	 * Question (1): Remove duplicates of a given linked list
	 */

	/**
	 * #2.1# Solution (1) for unordered linked list (HashSet approach)
	 */
    public static Node removeDuplicatesUnordered(Node head) {
        Node curr = head;
        Node prev = null;
        HashSet<Integer> set = new HashSet<>();
        	//Go over the list until ended is reached
            while ( curr != null) {
                if ( set.contains(curr.data)) //If the data of this node has been seen before
                    prev.next = curr.next; //Change reference of previous node to point to current nodes next node
                else {
                    set.add(curr.data); //Else add data to set
                    prev = curr; //Update previous to current
                }   
            curr = curr.next;   //update current to next node in list 
            }
        return head;
    }
    
    /**
	 * #2.1# Solution (2) for ordered linked list 
	 */
    public static Node removeDuplicatesOrdered(Node head) {
        // if head is null or only has 1 element
        if( head == null || head.next == null){
            return head;
        }
        
        // if list is more than 2 elements
        Node current = head.next;
        Node previous = head;
        while( current != null ) {
            // If current is a duplicate of previous
            if( previous.data == current.data ){
                // set previous' next pointer to skip over current node
                previous.next = current.next;
                // set current to next node in list, previous should not move
                current = current.next;
            }
            else { // node is not duplicate of previous
                previous = current;
                current = current.next;
            }
        }
        return head;
    }
    
    /**
     * Question (2): Return the Kth to last element in a linked list
     */
    
    /**
     * #2.2# Solution (1) (Iterative solution)
     */
    public static Node findKth(Node head, int k) {
    	Node p1 = head;
    	Node p2 = head;
    	
    	for ( int i = 0; i < k; i++) { //Move p1, K steps in the linked list
    		if ( p1 == null) return null;
    		p1 = p1.next;
    	}
    	
    	while ( p1 != null) { //Move p1 until it reaches the end, at that moment p2 will be Length - K steps or Kth elements from the end
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	
    	return p2;
    }
    
    /**
     * Question (3): Delete the middle element of a linked list given access to that element
     */
    /**
     * #2.3# Solution (1) (Copying references)
     */
    public static boolean removeElement( Node n) {
    	if ( n == null || n.next == null ) return false; //If element isn't in the middle, first or last
    	
    	Node next = n.next; //Reference to next node
    	n.data = next.data; //Copy data of next node
    	n.next = next.next; //Change next property to the next node of the existing next node to remove it
    	return true;
    }
    /**
     * Question (4): Partition Linked List
     */
    /**
     * #2.5# Solution (1) 
     */
    //To be implemented
    
    /**
     * Question (5): Addition in Linked List, Reversed and Normal order
     */
    /**
     * #2.5# Solution (1) for reversed Linked Lists
     */
    public static Node addList( Node l1, Node l2, int carry) {
    	if ( l1 == null && l2 == null && carry == 0) return null;
    	
    	int value = carry;
    	Node result = new Chapter2().new Node(0);
    	
    	if ( l1 != null) value += l1.data;
    	if ( l2 != null) value =+ l2.data;
    	result.data = value % 10;
    	
    	if( l1 != null || l2 != null) {
    		Node nextNode = addList( l1 == null ? null : l1, l2 == null ? null : l2, value >= 10 ? 1 : 0);
    		result.next = nextNode;
    	}
    	return result;
    }
    /**
     * #2.5# Solution (2) for normal order linked list
     */
    //To be implemented
    
    /**
     * Question (6) : Is linked list a palindorme?
     */
    /**
     * #2.6# Solution (1) Double pointer Stack solution
     */
    public static boolean isPalindorme( Node list) {
    	Node fastPtr = list;
    	Node slowPtr = list;
    	Stack<Integer>  stack = new Stack<>();
    	while ( fastPtr != null && fastPtr.next != null) {
    		stack.push(slowPtr.data);
    		fastPtr = fastPtr.next.next;
    		slowPtr = slowPtr.next;
    	}
    	
    	if ( fastPtr != null) slowPtr = slowPtr.next;

    	while ( slowPtr != null ) {
    		int value = stack.pop().intValue();
    		if ( slowPtr.data != value) return false;
    		slowPtr = slowPtr.next;
    	}
    	return true;
    }
}
