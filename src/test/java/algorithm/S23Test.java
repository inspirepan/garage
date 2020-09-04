package algorithm;

import datastructure.ListNode;
import org.junit.jupiter.api.Test;
import playground.ListUtils;

class S23Test {

    @Test
    void mergeKLists() {
        var s = new S23();
        ListUtils.printList(s.merge2Lists(new ListNode(1), new ListNode(5)));
    }
}