package datastructure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    public ListNode() {
        this.val = 0;
        this.next = null;
    }

    /**
     * 输出单链表
     */
    public void print() {
        System.out.println(val);
        ListNode ptr = next;
        if (ptr == null) {
            System.out.println("null");
            return;
        }
        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println(" ");
    }
}
