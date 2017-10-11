package jiuzhang.java.elementary;

public class MergeTwoSortedList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // corner case
        ListNode dummy1 = new ListNode(0);
        dummy1.next = l1;
        l1 = dummy1;
        ListNode dummy2 = new ListNode(0);
        dummy2.next = l2;
        l2 = dummy2;        
        ListNode dummy3 = new ListNode(0);
        ListNode l3 = dummy3;
        
        while (l1.next != null && l2.next != null) {
            if(l1.next.val <= l2.next.val ) {
                l3.next = l1.next;
                l1 = l1.next;
            } else {
                l3.next = l2.next;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        
        if (l1.next == null) {
            l3.next = l2.next;
        } else {
            l3.next = l1.next;
        }
        return dummy3.next;
    }
    
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // corner case
        ListNode dummy3 = new ListNode(0);
        ListNode l3 = dummy3;
        
        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val ) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        
        if (l1 == null) {
            l3.next = l2;
        } else {
            l3.next = l1;
        }
        return dummy3.next;
    }

}
