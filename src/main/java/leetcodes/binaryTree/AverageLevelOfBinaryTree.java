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
Output: [3.0000, 14.5000 ,11.000]

  */
public class AverageLevelOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        AverageLevelOfBinaryTree averageLevelOfBinaryTree = new AverageLevelOfBinaryTree();

        List<Double> result = averageLevelOfBinaryTree.averageLevelOfBinary(root);
        System.out.println(result);
    }


    public List<Double> averageLevelOfBinary(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double avergeLevel = 0;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                avergeLevel += currentNode.val;
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            avergeLevel = avergeLevel / levelSize;
            result.add(avergeLevel);
        }
        return result;
    }

}
