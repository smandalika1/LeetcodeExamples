public class MergeLinkedLists {
    public static void main(String args[]) {
       /* ListNode list12 = new ListNode(4);
        ListNode list11 = new ListNode(2, list12);
        ListNode list1 = new ListNode(1, list11);*/

        ListNode list1 = new ListNode(5);
        //ListNode list23 = new ListNode(7);
       /* ListNode list22 = new ListNode(4);
        ListNode list21 = new ListNode(2, list22);*/
        ListNode list2 = new ListNode(1);


        MergeLinkedLists ml = new MergeLinkedLists();
        ml.printList(list1);
        ml.printList(list2);
        ListNode finalnode=ml.mergeTwoLists(null, list2);
        System.out.println("last one--");
        ml.printList(finalnode);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempNode=new ListNode(0);
        ListNode currNode=tempNode;

        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                currNode.next=list1;
                list1=list1.next;
            }else{
                currNode.next=list2;
                list2=list2.next;
            }
            currNode=currNode.next;
        }

        if(list1!=null){
            currNode.next=list1;
            list1=list1.next;
        }
        if(list2!=null){
            currNode.next=list2;
            list2=list2.next;
        }
        return tempNode.next;
    }
    public ListNode mergeTwoListsOld(ListNode list1, ListNode list2) {
        ListNode newList=new ListNode();
        int len1=length(list1);
        int len2=length(list2);
        int[] finaList=new int[len1+len2];
        int i=0;
        System.out.println("lengths --"+len1+len2);
        for(int j=0;j<len1;j++){
            if(list2!=null){
                if(list1.val<=list2.val){
                    finaList[i++]=list1.val;
                    finaList[i++]=list2.val;
                }else{
                    finaList[i++]=list2.val;
                    finaList[i++]=list1.val;
                }
                list1=list1.next;
                list2=list2.next;
            }else{
                finaList[i++]=list1.val;
                list1=list1.next;
            }

        }


        while(list2!=null){
            System.out.println("values list --"+list2.val);
            if(i==0){
                finaList[i++]=list2.val;
            }
            else if(finaList[i-1]<=list2.val){
                finaList[i++]=list2.val;
            }else {
                int temp = finaList[i - 1];
                finaList[i - 1] = list2.val;
                finaList[i++] = temp;
            }
            list2=list2.next;
        }
        ListNode prevNode=null;
        for(int k=finaList.length-1;k>=0;k--){
           // System.out.println(finaList[k]);
            ListNode ln=new ListNode(finaList[k]);
            ln.next=prevNode;
            prevNode=ln;
        }

        return prevNode;
    }

    public void printList(ListNode newList){
        while(newList.next!=null){
            System.out.println(newList.val);
            newList=newList.next;
        }
        System.out.println(newList.val);
    }
    public int length(ListNode L){
        int len=0;
        while(L!=null){
            len++;
            L=L.next;
        }
        return len;
    }

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