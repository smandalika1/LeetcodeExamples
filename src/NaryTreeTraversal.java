import java.util.ArrayList;
import java.util.List;

public class NaryTreeTraversal {
    List<Integer> preOrderList=new ArrayList<Integer>();
    public static void main(String args[]){
        //Object[] treelist=new Object[]{1,null,3,2,4,null,5,6};
        Object[] treelist=new Object[]{1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14};
        NaryTreeTraversal ntt=new NaryTreeTraversal();
        Node rootNode=ntt.createTree(treelist);

        System.out.println(ntt.preorder(rootNode));
       // ntt.printTree(rootNode);
    }

    private void printTree(Node rootNode){
        if(rootNode==null){
            return;
        }
        System.out.println("childnode-"+rootNode.val);
        List<Node> children=rootNode.children;
        if(children!=null){
            for(Node childNode:children){
                //System.out.println("childnode-"+childNode.val);
                if(childNode!=null) {
                    printTree(childNode);
                }else{
                    return;
                }
            }
        }else{
            return;
        }

    }

    private Node createTree(Object[] treelist){
        List<Node> childrenList=new ArrayList<Node>();
        List<Node> subList=new ArrayList<Node>();
        int pos=-1;
        for(int i=0;i<treelist.length;i++){

            if(treelist[i]==null){
                subList=new ArrayList<Node>();
                pos++;
            }else{
                Node node=new Node((Integer)treelist[i]);
                //System.out.println("node val--"+node.val);

                subList.add(node);
                if(childrenList.size()>0 && childrenList.get(pos)!=null){
                    Node n=childrenList.get(pos);
                    //System.out.println("N node--"+n.val);
                    n.children=subList;
                    // System.out.println("N node children--"+n.children);
                }
                childrenList.add(node);

                //System.out.println("childrenList--"+childrenList);
                //System.out.println("subList--"+subList);
            }
        }

        return childrenList.get(0);
    }

    public List<Integer> preorder(Node rootNode) {
        if(rootNode==null){
            return preOrderList;
        }
        preorderTree(rootNode);
        return preOrderList;
    }

    private void preorderTree(Node rootNode){
        if(rootNode==null){
            return;
        }
        preOrderList.add(rootNode.val);
        List<Node> children=rootNode.children;
        if(children!=null){
            for(Node childNode:children){
                if(childNode!=null) {
                    preorderTree(childNode);
                }else{
                    return;
                }
            }
        }else{
            return;
        }

    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
