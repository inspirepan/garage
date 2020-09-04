package playground;

import datastructure.ListNode;

import java.util.StringJoiner;

public class ListUtils {
    public static void printList(ListNode head) {
        ListNode node = head;
        var sj = new StringJoiner("->");
        while (node != null) {
            sj.add(String.valueOf(node.val));
            node = node.next;
        }
        System.out.println(sj.toString());
    }
}
