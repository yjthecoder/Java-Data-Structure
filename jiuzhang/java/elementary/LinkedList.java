package jiuzhang.java.elementary;

class ListNode {
    int val;
    public ListNode next;
    public ListNode(int x)
    { val = x; }
}

public class LinkedList {
    public ListNode dummyNode;
    
    public LinkedList() {
        dummyNode = new ListNode(0);
    }
    
    public int get(int location) {
        ListNode cur = dummyNode;
        for (int i = 0; i <=  location; i++) {
            cur = cur.next;
        }
        
        return cur.val;
    }
    
    public void addBefore(int location, int val) {
        ListNode newNode = new ListNode(val);
        //initial spot
        ListNode pre = dummyNode;
        for (int i = 0; i < location; i++) {
            pre = pre.next;
        }
        
        newNode.next = pre.next;
        pre.next = newNode;
    }
    
    public void remove(int location){
        ListNode pre = dummyNode;
        for (int i = 0; i < location; i++) {
            pre = pre.next;
        }
        
        pre.next = pre.next.next;
    }
    
    public void print() {
        ListNode cur = dummyNode.next;
        
        // note :cur.next != null    v.s. cur != null
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }


    public static void main(String[] arg) {
        LinkedList aList = new LinkedList();
        
        aList.addBefore(0, 10);
        aList.addBefore(0, 20);
        aList.addBefore(0, 30);
        aList.addBefore(0, 40);
        aList.print();
        System.out.println(aList.get(0));
    }

}
