/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode d=new ListNode(-1);
        ListNode temp=d;
        int carry=0;
        while(l1!=null && l2!=null){
            int num1=l1.val,num2=l2.val;
            int data=num1+num2+carry;
            ListNode node=new ListNode(data%10);
            temp.next=node;
            temp=temp.next;
            carry=data/10;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int num1=l1.val;
            int data=num1+carry;
            ListNode node=new ListNode(data%10);
            temp.next=node;
            temp=temp.next;
            carry=data/10;
            l1=l1.next;
        }
        while(l2!=null){
            int num2=l2.val;
            int data=num2+carry;
            ListNode node=new ListNode(data%10);
            temp.next=node;
            temp=temp.next;
            carry=data/10;
            l2=l2.next;
        }
        if(carry!=0){
            ListNode node=new ListNode(carry);
            temp.next=node;
            temp=temp.next;
        }
        temp.next=null;
        return d.next;
    }
}