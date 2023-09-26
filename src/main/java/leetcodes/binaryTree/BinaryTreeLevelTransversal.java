package leetcodes.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
                    [3]
                /       \
            [9]        [20]
                      /    \
                   [15]    [7]
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []

  */
public class BinaryTreeLevelTransversal {

  public static void main(String[] args) {
    // Create a sample binary tree for testing
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    // Create an instance of your class
    BinaryTreeLevelTransversal solution = new BinaryTreeLevelTransversal();

    // Call the levelOrder method to obtain the result
    List<List<Integer>> result = solution.levelOrder(root);

    // Print the result
    System.out.println(result);
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>>  result = new ArrayList<>();
    if(root == null){
      return  result;
    }

    Queue<TreeNode>  queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      int levelSize = queue.size();
      ArrayList<Integer> currentLevel = new ArrayList<>(levelSize);
      for(int i = 0; i < levelSize; i++){
        TreeNode currentNode = queue.poll();
        currentLevel.add(currentNode.val);
        if(currentNode.left != null){
           queue.offer(currentNode.left);
        }
        if(currentNode.right != null){
          queue.offer(currentNode.right);
        }
      }
      result.add(currentLevel);
    }

    return result;
  }

}
