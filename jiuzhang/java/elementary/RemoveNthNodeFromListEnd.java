package jiuzhang.java.elementary;

public class RemoveNthNodeFromListEnd {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }
        
        ListNode oldHead = new ListNode(0);//can be any value
        oldHead.next = head;
        
        ListNode preTarget = oldHead;
        //make head n nodes ahead of pre
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        //when head is at end of list, preTarget is at n+1 from end of list
        while (head != null) {
            head = head.next;
            preTarget = preTarget.next;
        }
        //delete the target
        preTarget.next = preTarget.next.next;
        return oldHead.next;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
