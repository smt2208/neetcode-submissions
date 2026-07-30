class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Count length
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Delete head
        if (length == n) {
            return head.next;
        }

        // Move to previous node
        ListNode curr = head;

        for (int i = 1; i < length - n; i++) {
            curr = curr.next;
        }

        // Delete node
        curr.next = curr.next.next;

        return head;
    }
}