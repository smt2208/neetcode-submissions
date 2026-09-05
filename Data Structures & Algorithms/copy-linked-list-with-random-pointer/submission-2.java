/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
         if (head == null) return null;

        // Step 1: Map original → copy
        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;

        // Create copy nodes
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 2: Assign next and random
        curr = head;

        while (curr != null) {

            Node copy = map.get(curr);

            // Set next
            copy.next = map.get(curr.next);

            // Set random
            copy.random = map.get(curr.random);

            curr = curr.next;
        }

        // Return head of copied list
        return map.get(head);
    }
}