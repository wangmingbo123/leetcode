package leetcode2;


/**
 * Created by wy on 2017/6/14.
 */



public class p24 {
    public  void main() {
            ListNode listNode1=new ListNode(1);
            ListNode listNode2=new ListNode(2);
            ListNode listNode3=new ListNode(3);
            ListNode listNode4=new ListNode(3);
            listNode1.next=listNode2;
            listNode2.next=listNode3;
            listNode3.next=listNode4;
            swapPairs(listNode1);
    }


    public ListNode swapPairs(ListNode head) {
           ListNode temp=head;
           int i=0;
           while (temp!=null&&temp.next!=null){
                 if(i==0)
                     head=temp.next;
                 ListNode t=temp.next;
                 temp.next=temp.next.next;
                 t.next=temp;
                 i++;
                 //temp=temp.next.next;
           }
           return head;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
