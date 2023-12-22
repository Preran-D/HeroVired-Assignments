class MergeTwoSortedLinkedList {
    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static class MergeLinkedList {

        private static Node mergeLists(Node a, Node b) {
            Node dummy = new Node(-1);
            Node current = dummy;

            while (a != null && b != null) {
                if (a.val < b.val) {
                    current.next = a;
                    a = a.next;
                } else {
                    current.next = b;
                    b = b.next;
                }
                current = current.next;
            }

            if (a != null) {
                current.next = a;
            } else {
                current.next = b;
            }

            return dummy.next;
        }


        public static void main(String[] args) {
            Node a = new Node(1);
            a.next = new Node(3);
            a.next.next = new Node(5);

            Node b = new Node(2);
            b.next = new Node(4);
            b.next.next = new Node(6);

            Node mergedList = mergeLists(a, b);

            while (mergedList != null) {
                System.out.print(mergedList.val + " ");
                mergedList = mergedList.next;
            }


        }


    }

}
