package Chapter4;
/**
 * 
 * Check if a BST is height balanced or not
 */
import Chapter4.Question2.TreeNode;
public class Question4 {
	
	/**
	 * Check if a BST is height balanced in O(NlogN)
	 */
	int getHeight(TreeNode t) {
		if ( t == null ) return 0;
		return Math.max(getHeight(t.left), getHeight(t.right));
	}
	
	boolean isBalanced( TreeNode t) {
		if ( t == null) return true;
		
		int lh = getHeight(t.left);
		int rh = getHeight(t.right);
		
		if ( Math.abs(lh - rh) < 2) 
			return isBalanced(t.left) && isBalanced(t.right);
		return false;
	}
	
	/**
	 * Check if a BST is height Balanced in O(N) 
	 */
	int isOptimBalanced( TreeNode t) {
		if ( t == null) return 0;
		
		int lh = isOptimBalanced(t.left);
		if ( lh == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int rh = isOptimBalanced(t.right);
		if ( rh == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		if ( Math.abs(lh -rh) > 1) 
			return Integer.MIN_VALUE;
		else
			return Math.max(lh, rh) + 1;
	}
	
	boolean checkBalance(TreeNode t) {
		return isOptimBalanced(t) != Integer.MIN_VALUE;
	}


}
