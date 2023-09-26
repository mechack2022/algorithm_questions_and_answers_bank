package leetcodes.binaryTree;
/*
 Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
                         [3]
                    /         \
                 /              \
            [4]                 [8]
        /      \              /    \
     [12]      [14]          [7]    [11]
               /  \                 /
            [36]   [9]           [2]
                                    \
                                    [44]





Input: root = [3,4,8,12, 14 ,7, 11, null, null, 36, 9, null, null , 2, null, null, null, null, null , null 44], target = 4
Output: if target  is 4 output = 8, if target is 11 0uput = 36, if target is 12 ouput = 14

  */

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode( 4);
        root.right = new TreeNode( 8);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(14);
        root.left.right.left = new TreeNode(36);
        root.left.right.right = new TreeNode( 9);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(11);
        root.right.right.left = new TreeNode( 2);
        root.right.right.left.right = new TreeNode(44);

        LevelOrderSuccessor levelOrderSuccessor = new LevelOrderSuccessor();
        TreeNode result = levelOrderSuccessor.levelOrderSuccessor(root, 12);
        System.out.println(result);


    }

    public TreeNode levelOrderSuccessor(TreeNode root, int target){

        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
      while(!queue.isEmpty()){
          TreeNode currentNode = queue.poll();
          if(currentNode.left != null){
              queue.offer(currentNode.left);
          }
          if(currentNode.right != null){
              queue.offer(currentNode.right);
          }
          if(currentNode.val == target){
              break;
          }
      }
//      Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
        return queue.peek();

    }
}
