import java.util.HashSet;

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
    

}
