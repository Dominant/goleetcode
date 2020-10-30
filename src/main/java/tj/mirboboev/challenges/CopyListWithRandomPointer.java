package tj.mirboboev.challenges;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        //[[3,null],[3,0],[3,null]]

        Node head = new Node(3);

        head.next = new Node(3);
        head.next.random = head;

        head.next.next = new Node(3);

        new CopyListWithRandomPointer().copyRandomList(head);
    }

    public Node copyRandomList(Node head) {
        Node current = head;

        while (head != null) {
            Node currentCopy = new Node(current.val);
            Node currentNext = head.next;
            head.next = currentCopy;
            currentCopy.next = currentNext;

            head = currentNext;
        }

        Node currentCopy = current;

        while (current != null) {
            Node currentReference = current;

            if (current.random == null) {
                current.next.random = null;
            } else {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }


        return currentCopy.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
