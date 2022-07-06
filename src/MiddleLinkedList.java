public class MiddleLinkedList {

    public static void main(String args[]){
        ListNode list13 = new ListNode(5);
        ListNode list12 = new ListNode(4,list13);
        ListNode list11 = new ListNode(2, list12);
        ListNode list1 = new ListNode(1, list11);
        MiddleLinkedList mll=new MiddleLinkedList();
        System.out.println(mll.middleNode(list1).val);
    }
    public ListNode middleNode(ListNode head) {
        ListNode nextNode=head.next;
        ListNode currNode=head;

        while(nextNode!=null){
            //System.out.println("currnode--"+currNode.val);
            //System.out.println("nextNode--"+nextNode.val);
            //currNode=head.next;
           // nextNode=head.next.next;

            currNode=currNode.next;
            if(nextNode.next!=null) {
                nextNode = nextNode.next.next;
            }else{
                break;
            }

            //System.out.println("currnode-2-"+currNode.val);
           // System.out.println("nextNode--"+nextNode.val);
        }

        return currNode;
    }
}
