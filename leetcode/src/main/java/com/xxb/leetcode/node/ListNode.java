package com.xxb.leetcode.node;

public class ListNode {

    private int i;
    private ListNode next;

    public ListNode(int i) {
        this.i = i;
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode frontHead = head;
        ListNode behindHead = head;
        while (k != 0 && null != behindHead){
            behindHead = behindHead.next;
            k --;
        }
        while (behindHead != null){
            frontHead = frontHead.next;
            behindHead = behindHead.next;
        }
        return frontHead;
    }
}

