package Chapter4;
import java.util.ArrayDeque;
import java.util.ArrayList;
/**
 * Implement a BFS search to find if a route exists between two nodes in a graph
 *
 */
public class Question1 {
	
	class GraphNode {
		public int data;
		public boolean visited; // needed for BFS, DFS
		private ArrayList<GraphNode> neighbors; // could alternatively use a HashSet (and give nodes unique IDs)
		
		/* Constructor */
		public GraphNode(int data) {
			this.data = data;
			visited   = false;
			neighbors = new ArrayList<>();
		}
		
		public void visit() {
			visited = true;
		}
		
		public ArrayList<GraphNode> getNeighbors() {
			return neighbors;
		}
		
		public void addNeighbor(GraphNode neighbor) {
			neighbors.add(neighbor);
			neighbor.neighbors.add(this);
		}
		
		public void addDirectedNeighbor(GraphNode neighbor) {
			neighbors.add(neighbor);
		}
	}

	public static boolean routeExists(GraphNode start, GraphNode end) {
		if (start == end) {
			return true;
		}
		
		ArrayDeque<GraphNode> deque = new ArrayDeque<>(); 
		start.visit();
		deque.add(start);
		
		while (!deque.isEmpty()) {
			GraphNode curr = deque.remove();
			if ( curr != null) {
				if (curr == end) {
					return true;
				}
				for (GraphNode neighbor : curr.getNeighbors()) {
					if (!neighbor.visited) {
						neighbor.visit();
						deque.add(neighbor);
					}
				}
				curr.visit();
			}
		}
		return false;
}
}
