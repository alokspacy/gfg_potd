// Delete Nodes with Greater on Right

/* Structure of linked list node
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    // Function to reverse a linked list
    private Node reverse(Node head) {
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    Node compute(Node head) {
        // Step 1: Reverse the list
        head = reverse(head);

        // Step 2: Traverse and delete nodes smaller than max so far
        Node curr = head;
        int max = curr.data;
        while (curr != null && curr.next != null) {
            if (curr.next.data < max) {
                // delete curr.next
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                max = curr.data;
            }
        }

        // Step 3: Reverse back to restore original order
        head = reverse(head);
        return head;
    }
}
