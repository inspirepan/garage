package dataStructure;

public class LinkList {
    public ListNode headNode;

    public LinkList() {
    }

    public LinkList(int[] initialData) {
        if (initialData.length == 0) {
            this.headNode = new ListNode();
        } else {
            this.headNode = new ListNode(initialData[0]);
            ListNode p = this.headNode;
            for (int i = 1; i < initialData.length; i++) {
                ListNode x = new ListNode(initialData[i]);
                p.next = x;
                p = x;
            }
        }
    }

}
