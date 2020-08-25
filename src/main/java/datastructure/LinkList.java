package datastructure;

/**
 * Only used for LeetCode
 */
public class LinkList {
    public ListNode head;

    public LinkList() {
    }

    public LinkList(int[] initialData) {
        if (initialData.length == 0) {
            this.head = new ListNode();
        } else {
            this.head = new ListNode(initialData[0]);
            ListNode p = this.head;
            for (int i = 1; i < initialData.length; i++) {
                ListNode x = new ListNode(initialData[i]);
                p.next = x;
                p = x;
            }
        }
    }

}
