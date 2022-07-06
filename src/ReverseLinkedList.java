public class ReverseLinkedList {
    public static void main(String args[]){

        ListNode list23 = new ListNode(7);
        ListNode list22 = new ListNode(4,list23);
        ListNode list21 = new ListNode(2, list22);
        ListNode list2 = new ListNode(1,list21);

        ReverseLinkedList rll=new ReverseLinkedList();
       // rll.printList(list2);
        System.out.println("in reverse order");
        rll.printList(rll.reverseList(list2));
    }
    public ListNode reverseList(ListNode head) {
        ListNode newList=null;
        ListNode preNode=null;
        if(head==null){
            return null;
        }
        while(head!=null){
            newList=new ListNode(head.val);
            newList.next=preNode;
            preNode=newList;
            head=head.next;
        }
        return newList;
    }
    public void printList(ListNode newList){
        while(newList.next!=null){
            System.out.println(newList.val);
            newList=newList.next;
        }
        System.out.println(newList.val);
    }
}


