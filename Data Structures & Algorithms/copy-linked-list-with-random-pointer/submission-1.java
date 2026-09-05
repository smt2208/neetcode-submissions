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

        Node curr = head;// traverse in OG LL
        Node prev=null;// new LL connecting
        Node newHead=null;// to return the new LL

        // Create copy nodes
        while (curr != null) {
            Node temp=new Node(curr.val);
            map.put(curr,temp);//storing in map 
            if(newHead==null){
                newHead=temp;
                prev=newHead;
            }else{
                prev.next=temp;
                prev=temp;
            }
            curr=curr.next;
        }

        // Step 2: fill random pointer
        curr = head;
        Node newCurr=newHead;
        while (curr!=null) {

            if(curr.random==null){
                newCurr.random=null;
            }else{
                newCurr.random=map.get(curr.random);
            }

            curr=curr.next;
            newCurr=newCurr.next;
        }
        return newHead;
    }
}