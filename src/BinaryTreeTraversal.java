import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {
    List<List<Integer>> treeOrderList=new ArrayList<List<Integer>>();

    public static void main(String args[]) {
        BinaryTreeTraversal bst=new BinaryTreeTraversal();
        Object[] treelist=new Object[]{3,9,20,null,null,15,7};
        TreeNode rootNode=bst.createTree(treelist);
        bst.printTree(rootNode);
        System.out.println(bst.levelOrder(rootNode));
    }
    private void printTree(TreeNode root){
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.right.left.val);
        System.out.println(root.right.right.val);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        int level=0;
        if(root==null){
            return treeOrderList;
        }else{
            levelOrderTree( root, level);
            return treeOrderList;
        }
    }

    private void levelOrderTree(TreeNode root,int level){
        //System.out.println("root.val---"+root.val+ "---level--"+level +"--treeOrderList.size()--"+treeOrderList.size());
        if(root==null){
            return;
        }else{
            List<Integer> treeNodeList=null;
            if(treeOrderList.size()>level){
                treeNodeList=treeOrderList.get(level);
            }
            if(treeNodeList==null ){
                treeNodeList=new ArrayList<Integer>();
            }
            treeNodeList.add(root.val);
            if(treeOrderList.size()>level) {
                treeOrderList.set(level, treeNodeList);
            }else{
                treeOrderList.add( treeNodeList);
            }

            level++;
            if(root.left!=null){
                levelOrderTree( root.left, level);
            }
            if(root.right!=null){
                levelOrderTree( root.right, level);
            }
        }
    }
    private void levelOrderTree1(TreeNode root,int level){
        if(root==null){
            return;
        }else{
            if(treeOrderList!=null && treeOrderList.size()>0 && treeOrderList.get(level)!=null){
                List<Integer> sublist=treeOrderList.get(level);
                sublist.add(root.val);

            }else{
                List<Integer> sublist=new ArrayList<Integer>() ;
                sublist.add(root.val);
                treeOrderList.add(sublist);
                level++;

            }
            if(root.left!=null){
                levelOrderTree( root.left,level);
            }
            if(root.right!=null){
                levelOrderTree( root.right,level);
            }
        }
    }
    private TreeNode createTree(Object[] treeList) {
        List<TreeNode> nodeList=new ArrayList<TreeNode>();
        int pos=0;
        for(int i=0;i<treeList.length;i++){

            Object obj=treeList[i];
            System.out.println("obj--"+obj);
            if(obj!=null){
                TreeNode node=new TreeNode((Integer)obj);
                if(nodeList!=null && nodeList.size()>0){
                    TreeNode parentNode=nodeList.get(pos);
                    if(parentNode.left==null){
                        parentNode.left=node;
                    }else if(parentNode.right==null){
                        parentNode.right=node;
                    }
                }
                nodeList.add(node);
            }else{
                pos++;
            }
        }
        return nodeList.get(0);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 