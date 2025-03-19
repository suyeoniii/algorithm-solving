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
    public ListNode insertionSortList(ListNode head) {
        
        ListNode pointer = head; // 위치를 찾을 노드
        ListNode dummy = new ListNode(0); // 정렬된 리스트 시작점

        while(pointer != null) {
            ListNode prev = dummy; // 삽입할 위치 포인터
            ListNode next = pointer.next; // 다음노드 임시저장

            // 적절한 삽입 위치 찾기
            while(prev.next != null && prev.next.val < pointer.val) {
                prev = prev.next;
            }

            // 삽입
            pointer.next = prev.next;
            prev.next = pointer;

            // 다음 노드 가리키기
            pointer = next;
        }

        // 정렬된 리스트 반환 (더미 리스트의 다음거부터)
        return dummy.next;
    }
}