import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Q2 {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        System.out.println(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list != null) pq.add(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
            if (curr.next != null) pq.add(curr.next);
        }
        return dummy.next;
    }
}
