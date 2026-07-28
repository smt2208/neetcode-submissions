//reucrsive soln
class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // If list1 is empty, return list2
        if (list1 == null)
            return list2;

        // If list2 is empty, return list1
        if (list2 == null)
            return list1;

        // Choose the smaller node
        if (list1.val <= list2.val) {

            // Merge the remaining nodes
            list1.next = mergeTwoLists(list1.next, list2);

            // list1 becomes the head
            return list1;

        } else {

            // Merge remaining nodes
            list2.next = mergeTwoLists(list1, list2.next);

            // list2 becomes the head
            return list2;
        }
    }
}