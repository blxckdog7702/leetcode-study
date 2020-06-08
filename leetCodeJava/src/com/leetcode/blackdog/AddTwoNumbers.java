package com.leetcode.blackdog;

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        addTwoNumbers.test();
    }

    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Node = l1;
        ListNode l2Node = l2;
        ListNode result = new ListNode();
        ListNode resultNode = result;

        boolean add = false;

        while(l1Node != null || l2Node != null) {
            int l1Value = 0;
            int l2Value = 0;

            if(l1Node != null) {
                l1Value = l1Node.val;
                l1Node = l1Node.next;
            }

            if(l2Node != null) {
                l2Value = l2Node.val;
                l2Node = l2Node.next;
            }

            if(add) {
                l1Value++;
                add = false;
            }

            int val = l1Value + l2Value;

            if(l1Value + l2Value >= 10) {
                add = true;
                val -= 10;
            }

            resultNode.next = new ListNode(val);
            resultNode = resultNode.next;
        }

        if(add) {
            resultNode.next = new ListNode(1);
        }

        return result.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
