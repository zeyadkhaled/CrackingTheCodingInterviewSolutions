package Chapter4;
/**
 * Implement a method that creates a minimal binary tree from a sorted int array
 *
 */
public class Question2 {
	

	class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode( int n) { data = n;}
	}
	
	static TreeNode createMinTree(int[] arr) {
		if (arr.length < 1) return null;
		return createMinTreeHelper(arr, 0, arr.length-1);
	}
	
	static TreeNode createMinTreeHelper(int[] arr, int start, int end) {
		if ( end < start ) return null;
		int mid = ( start + end) / 2;
		TreeNode node = new Question2().new TreeNode(arr[mid]);
		node.left = createMinTreeHelper( arr, start, mid - 1);
		node.right = createMinTreeHelper(arr, mid + 1, end);
		return node;
	}
	
	static void printTree( TreeNode t) {
		if ( t != null) {
			System.out.println(t.data);
			printTree( t.left);
			printTree( t.right);
		}
	}
	
	public static void main( String[] args) {
		
		int[] n = {1,2,3,4,5,6,7,8,9};
		TreeNode tree = createMinTree(n);
		printTree(tree);
	
	}

	

}
