Find the minimum depth of a binary tree. The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node

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
  public int findDepth(TreeNode root) {
    // TODO: Write your code here

    if(root == null) 
      return 0;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int minimumTreeDepth = 0;

    while(!queue.isEmpty()) {
      minimumTreeDepth++;
      int size = queue.size();

      for(int i = 0; i < size; i++) {
        TreeNode temp = queue.poll();

        // if its a leaf node
        if(temp.left == null && temp.right == null) {
          return minimumTreeDepth;
        }

        if(temp.left != null) {
          queue.add(temp.left);
        }
        if(temp.right != null) {
          queue.add(temp.right);
        }
      }
    }
    return minimumTreeDepth;
  }
}
