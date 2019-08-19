package cn.tryboom.one;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

public class TwoNumberSum {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        while (l1 != null) {
            s1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.append(l2.val);
            l2 = l2.next;
        }
        int sum = Integer.parseInt(s1.toString()) + Integer.parseInt(s2.toString());
        String s = String.valueOf(sum);
        //TODO 如何将此字符串转化为node
        System.out.println(s);
        return new ListNode(s.charAt(s.length() - 1));
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder s2 = new StringBuilder();
        while (this.next != null) {
            s2.append(val);
            next = this.next.next;
        }
        return s2.toString();
    }

}
