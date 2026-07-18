class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // If the list has 0 or 1 node, no pairs exist to insert between
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = head;
        
        while (curr != null && curr.next != null) {
            // 1. Find the GCD using the Euclidean formula
            int gcdValue = gcd(curr.val, curr.next.val);
            
            // 2. Create the new node
            ListNode gcdNode = new ListNode(gcdValue);
            
            // 3. Insert it between curr and curr.next
            gcdNode.next = curr.next;
            curr.next = gcdNode;
            
            // 4. Move curr past the newly inserted node to the next original node
            curr = gcdNode.next;
        }
        
        return head;
    }
    
    // Recursive Euclidean algorithm for GCD
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}