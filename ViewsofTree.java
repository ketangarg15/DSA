
import java.util.*;
class Pair{
    TreeNode node;
    int hd;
    Pair(TreeNode n,int h){
        node=n;
        hd=h;
    }
}
public class ViewsofTree {
    public static void horizontalView(TreeNode root){
        List<Integer> view=new ArrayList<>();
        if(root==null){
            return;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            view.add(curr.val);
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
        for(int val:view){
            System.out.print(val+" ");
        }
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
    public static void verticalView(TreeNode root){
        TreeMap<Integer,List<Integer>> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            TreeNode node=p.node;
            int hd=p.hd;
            map.putIfAbsent(hd,new ArrayList<>());
            map.get(hd).add(node.val);
            if(node.left!=null){
                q.add(new Pair(node.left,hd-1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right, hd+1));
            }
        }
        for(List<Integer> list:map.values()){
            for(int val:list){
                System.out.print(val+" ");
            }
        }
    }
    public static void leftView(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(i==0){
                    ans.add(curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        for(int val:ans){
            System.out.print(val+" ");
        }
    }
    public static void rightView(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(i==size-1){
                    ans.add(curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        for(int val:ans){
            System.out.print(val+" ");
        }
    }
    public static void topView(TreeNode root){
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            TreeNode node=p.node;
            int hd=p.hd;
            if(!map.containsKey(hd)){
                map.put(hd,node.val);
            }
            if(node.left!=null){
                q.add(new Pair(node.left, hd-1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right, hd+1));
            }
        }
        for(int val:map.values()){
            System.out.print(val+" ");
        }
    }
    public static void bottomView(TreeNode root){
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            TreeNode node=p.node;
            int hd=p.hd;
            map.put(hd,node.val);
            if(node.left!=null){
                q.add(new Pair(node.left, hd-1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right, hd+1));
            }
        }
        for(int val:map.values()){
            System.out.print(val+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode root=buildTree(sc);
        horizontalView(root);
        System.out.println();
        verticalView(root);
        System.out.println("");
        leftView(root);
        System.out.println("");
        rightView(root);
        System.out.println("");
        topView(root);
        System.out.println("");
        bottomView(root);
    }
}