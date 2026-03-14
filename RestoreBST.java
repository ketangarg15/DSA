import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int v){
        val=v;
    }
}
public class RestoreBST{
    static TreeNode firstprev=null;
    static TreeNode secondprev=null;
    static TreeNode prev=null;
    public static void recoverbst(TreeNode root){
        inorder(root);
        if(firstprev != null && secondprev != null){
            int temp = firstprev.val;
            firstprev.val = secondprev.val;
        secondprev.val = temp;
        }
    }
    public static void inorder(TreeNode root){
    if(root == null){
        return;
    }

    inorder(root.left);

    if(prev != null && firstprev == null && root.val < prev.val){
        firstprev = prev;
    }

    if(prev != null && firstprev != null && root.val < prev.val){
        secondprev = root;
    }

    prev = root;

    inorder(root.right);
}
    public static TreeNode buildTree(Scanner sc){
        int val=sc.nextInt();
        if(val==-1){
            return null;
        }
        TreeNode root=new TreeNode(val);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            int left=sc.nextInt();
            if(left!=-1){
                curr.left=new TreeNode(left);
                queue.add(curr.left);
            }
            int right=sc.nextInt();
            if(right!=-1){
                curr.right=new TreeNode(right);
                queue.add(curr.right);
            }
        }
        return root;
    }
    public static void printinorder(TreeNode root){
        if(root==null){
            return ;
        }
        printinorder(root.left);
        System.out.println(root.val+" ");
        printinorder(root.right);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode root=buildTree(sc);
        recoverbst(root);
        printinorder(root);
    }
}