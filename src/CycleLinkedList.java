import java.util.*;

public class CycleLinkedList {
    public static void main(String args[]){
        ListNode list13 = new ListNode(5);
        ListNode list12 = new ListNode(4,list13);
        ListNode list11 = new ListNode(2, list12);
        ListNode list1 = new ListNode(1, list11);
        CycleLinkedList cll=new CycleLinkedList();
        System.out.println(cll.detectCycle(list1));
    }
    public ListNode detectCycle(ListNode head) {
        ListNode currNode=head;
        List<ListNode> list=new ArrayList<ListNode>();
        while(currNode!=null){
            if(list.contains(currNode)){
                return currNode;
            }
            list.add(currNode);
            currNode=currNode.next;
        }
        return null;
    }
}
