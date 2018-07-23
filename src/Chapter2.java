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
    
    
    

}
