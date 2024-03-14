Given a binary tree, populate an array to represent the averages of all of its levels.

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
  public List<Double> findLevelAverages(TreeNode root) {
    // List<Double> result = new ArrayList<>();
    // TODO: Write your code here

    List<Double> result = new ArrayList<>();
    if(root == null) {
      return null;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()) {
      int size = queue.size();
      double sum = 0;
      for(int i = 0; i < size; i++) {
        TreeNode temp = queue.poll();
        sum += temp.val;
    
      if(temp.left != null) 
        queue.add(temp.left);
      

      if(temp.right != null) 
         queue.add(temp.right);    
    }
    result.add(sum/size);
  }
  return result;
  }
}
