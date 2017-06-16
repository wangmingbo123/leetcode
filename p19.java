package leetcode2;

/**
 * Created by wy on 2017/6/16.
 */
public class p19 {
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int i=0;
        while (temp!=null){
            temp=temp.next;
            i++;
        }
        int num=i-n;
        temp=head;
        int k=0;
        while (temp!=null&&k<num-1){
            temp=temp.next;
            k++;
        }
        if(num==0){
            head=head.next;
        }



        if(temp.next!=null)
            temp.next=temp.next.next;
        return head;
    }

}
