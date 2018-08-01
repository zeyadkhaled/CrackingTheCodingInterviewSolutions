package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import Chapter4.Question2;
import Chapter4.Question2.TreeNode;
/**
 * Create a method that returns all the node on each level in a seperate linkedlist
 *
 */
public class Question3 {

	public static ArrayList<LinkedList<TreeNode>> getLevels( ArrayList<LinkedList<TreeNode>>  lists, TreeNode t, int level  ) {
		if ( t == null) return null;
		LinkedList<TreeNode> list = new LinkedList<>();
		if ( lists.size() == level) {
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(t);
		getLevels(lists, t.left, level + 1);
		getLevels(lists, t.right, level + 1);
		return lists;
	}

}
