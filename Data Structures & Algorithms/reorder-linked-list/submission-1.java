/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {

        // Edge case: if list has 0 or 1 node, no reordering is needed.
        if (head == null || head.next == null) {
            return;
        }

        // -------------------------------
        // Step 1: Find the middle of the linked list
        // Slow moves 1 step, Fast moves 2 steps.
        // When Fast reaches the end, Slow will be at the middle.
        // -------------------------------
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // -------------------------------
        // Step 2: Reverse the second half
        // Split the list into two halves.
        // Example:
        // 1 -> 2 -> 3 -> 4 -> 5
        // First : 1 -> 2 -> 3
        // Second: 4 -> 5
        // Reverse second half:
        // 5 -> 4
        // -------------------------------
        ListNode second = slow.next;
        ListNode prev = null;
        slow.next = null;      // Break the list into two halves

        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // -------------------------------
        // Step 3: Merge the two halves alternately
        // First : 1 -> 2 -> 3
        // Second: 5 -> 4
        // Result:
        // 1 -> 5 -> 2 -> 4 -> 3
        // -------------------------------
        ListNode first = head;
        second = prev;

        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }
}