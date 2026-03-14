import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Boundary_traversal {
    static boolean isLeaf(TreeNode node){
        return node.left==null && node.right==null;
    }
    static void leftBoundary(TreeNode root){
        TreeNode curr=root.left;
        while(curr!=null){
            if(!isLeaf(curr)){
                System.out.print(curr.val+" ");
            }
            if(curr.left!=null){
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
    }
    static void leafNodes(TreeNode root){
        if(root==null){
            return;
        }
        if(isLeaf(root)){
            System.out.print(root.val+" ");
            return;
        }
        leafNodes(root.left);
        leafNodes(root.right);
    }
    static void rightBoundary(TreeNode root){
        Stack<Integer> stack=new Stack<>();
        TreeNode curr=root.right;
        while(curr!=null){
            if(!isLeaf(curr)){
                stack.push(curr.val);
            }
            if(curr.right!=null){
                curr=curr.right;
            }
            else{
                curr=curr.left;
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
    public static void boundaryTraversal(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        leftBoundary(root);
        leafNodes(root.left);
        leafNodes(root.right);
        rightBoundary(root);
    }
    
    public static TreeNode buildTree(Scanner sc) {
        int val = sc.nextInt();
        if (val == -1) return null;

        TreeNode root = new TreeNode(val);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            int left = sc.nextInt();
            if (left != -1) {
                curr.left = new TreeNode(left);
                q.add(curr.left);
            }

            int right = sc.nextInt();
            if (right != -1) {
                curr.right = new TreeNode(right);
                q.add(curr.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode root=buildTree(sc);
        boundaryTraversal(root);
    }
}