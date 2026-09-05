class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // original node → its copy
        Map<Node, Node> map = new HashMap<>();

        // ---------- First pass: copy nodes & next ----------
        Node curr = head;
        Node newHead = null, prev = null;
        while (curr != null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);

            if (newHead == null) {          // first node
                newHead = copy;
            } else {
                prev.next = copy;           // link after previous copy
            }
            prev = copy;                    // move prev forward
            curr = curr.next;
        }

        // ---------- Second pass: assign random ----------
        curr = head;
        Node copyCurr = newHead;
        while (curr != null) {
            copyCurr.random = (curr.random == null) ? null : map.get(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return newHead;
    }
}