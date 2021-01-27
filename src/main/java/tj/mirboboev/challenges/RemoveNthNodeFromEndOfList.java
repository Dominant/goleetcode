package tj.mirboboev.challenges;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        new Solution().removeNthFromEnd(new ListNode(1), 1);
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
     
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            Map<Integer, ListNode> nodeMap = new HashMap<>();
            ListNode curr = head;
            int i = 0;

            if (head == null) {
                return head;
            }

            while (curr != null) {
                nodeMap.put(i, curr);
                curr = curr.next;
                i++;
            }

            int deleteIndex = i - n;
            int prevToLink = i - n - 1;
            int nextToLink = i - n + 1;

            if (nodeMap.get(deleteIndex) == null) {
                return head;
            }

            if (nodeMap.get(prevToLink) == null) {
                head = null;

                if (nodeMap.get(nextToLink) != null) {
                    head = nodeMap.get(nextToLink);
                }
            } else {
                nodeMap.get(prevToLink).next = nodeMap.get(deleteIndex).next;
            }

            return head;
        }
    }
}
