package leetcodes;
/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeTwoSortedList {


    public static void main(String[] args) {
        ListNode list1Example1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2Example1 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode list1Example2 = null;
        ListNode list2Example2 = null;

        ListNode list1Example3 = null;
        ListNode list2Example3 = new ListNode(0);

        // Create an instance of the Solution class
        MergeTwoSortedList solution = new MergeTwoSortedList();

        // Test the examples
        ListNode mergedExample1 = solution.mergeTwoLists(list1Example1, list2Example1);
        ListNode mergedExample2 = solution.mergeTwoLists(list1Example2, list2Example2);
        ListNode mergedExample3 = solution.mergeTwoLists(list1Example3, list2Example3);

        // Print the merged lists
        System.out.println(mergedExample1);
        System.out.println(mergedExample2);
        System.out.println(mergedExample3);
    }
    private static class ListNode {

        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return
                    val + " , " + next ;

        }
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // Dummy node to start the merged list
        ListNode current = dummy; // Pointer to traverse the merged list

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Append any remaining nodes from list1 or list2
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        return dummy.next;
    }
}
