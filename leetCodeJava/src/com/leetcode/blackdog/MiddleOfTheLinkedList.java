package com.leetcode.blackdog;

public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode result = head;
        int count = 1;
        ListNode node = head;

        while(node.next != null) {
            if(count % 2 == 1) {
                result = result.next;
            }

            count++;
            node = node.next;
        }

        return result;
    }

    public static void main(String[] args) {
        MiddleOfTheLinkedList problem = new MiddleOfTheLinkedList();
        ListNode head = problem.setUp();

        System.out.println(problem.middleNode(head).val);
    }

    private ListNode setUp() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;

        ListNode node3 = new ListNode(3);
        node2.next = node3;

        ListNode node4 = new ListNode(4);
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        node4.next = node5;

//        ListNode node6 = new ListNode(6);
//        node5.next = node6;

        return node1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}