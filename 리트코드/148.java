/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.val);
        System.out.println(fast.val);

        ListNode mid = slow.next;
        slow.next = null;

        return merge(sortList(head), sortList(mid));
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode list = new ListNode();
        ListNode tail = list;
        while(left != null && right != null) {
            if (left.val < right.val) { // 우측이 더 크면
                tail.next = left;
                left = left.next;
            } else { // 좌측이 크거나 같으면
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if (left != null) {
            tail.next = left;
        }
        if (right != null) {
            tail.next = right;
        }

        return list.next;
    }
}