class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedListPartition {

    public static ListNode partitionLinkedList(ListNode head, int x) {
        ListNode lesser = new ListNode(0);
        ListNode greater = new ListNode(0);

        ListNode lessThanX = lesser;
        ListNode greaterThanOrEqualX = greater;

        ListNode current = head;

        while (current != null) {
            if (current.value < x) {
                lessThanX.next = current;
                lessThanX = lessThanX.next;
            } else {
                greaterThanOrEqualX.next = current;
                greaterThanOrEqualX = greaterThanOrEqualX.next;
            }

            current = current.next;
        }

        lessThanX.next = greater.next;
        greaterThanOrEqualX.next = null;

        return lesser.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // linked list: 1 -> 4 -> 3 -> 2 -> 5 -> 2
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(2);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(2);

        // linked list with target value x = 3
        ListNode result = partitionLinkedList(a, 3);

        printList(result);
    }
}
