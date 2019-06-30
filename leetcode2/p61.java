package leetcode2;

/**
 * Created by wy on 2017/6/14.
 */
public class p61 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode rotateRight(ListNode head, int k) {
           if(head==null)
               return null;

        ListNode temp=head;
        int n=2;
        while (temp.next!=null){
               temp=temp.next;
               n++;
        }
        ListNode tail=temp;
        temp=head;
        int i=1;
        while (i<n-k){
              temp=temp.next;
              i++;
        }

        ListNode newHead=temp.next;
        temp.next=null;
        tail.next=head;

        return newHead;

    }
}
