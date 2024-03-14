Given a binary tree, populate an array to represent its zigzag level order traversal. You should populate the values of all nodes of the first level from left to right, then right to left for the next level and keep alternating in the same manner for the following levels.

  import java.util.*;

/*class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};*/

class Solution {
  public List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    // TODO: Write your code here

    if(root == null) {
      return null;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int level = 1;
    while(!queue.isEmpty()) {
      int size = queue.size();
      LinkedList<Integer> currentLevel = new LinkedList<>();
      for(int i = 0; i < size; i++) {
        TreeNode temp = queue.remove();

        if(level % 2 == 0) {
          currentLevel.addFirst(temp.val);
        } else {
          currentLevel.add(temp.val);
        }

        if(temp.left != null) {
          queue.add(temp.left);
        }
        if(temp.right != null) {
          queue.add(temp.right);
        }
      }
      result.add(currentLevel);
      level++;
    }
    return result;
  }
}
