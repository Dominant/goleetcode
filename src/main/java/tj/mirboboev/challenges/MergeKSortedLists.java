package tj.mirboboev.challenges;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(4);
        root1.next.next = new ListNode(5);

        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(3);
        root2.next.next = new ListNode(4);

        ListNode root3 = new ListNode(2);
        root3.next = new ListNode(6);

        ListNode result = new MergeKSortedLists().mergeKLists(new ListNode[]{root1, root2, root3});

        printList(result);
        System.out.println("");

        root1 = new ListNode(-2);
        root1.next = new ListNode(-1);
        root1.next.next = new ListNode(-1);
        root1.next.next.next = new ListNode(-1);

        result = new MergeKSortedLists().mergeKLists(new ListNode[]{root1});
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print("Node : " + node.val + " -> ");
            node = node.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else if (o2.val > o1.val) {
                    return -1;
                }

                return 0;
            }
        });

        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (queue.size() > 0) {
            head.next = queue.poll();
            head = head.next;
            head.next = null;
        }

        return curr.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
