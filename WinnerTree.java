import java.util.*;

class WinnerTree {

    static int[] tree;

    static void buildArray(int arr[]) {
        int n = arr.length;
        tree = new int[2*n];

        for(int i=0;i<n;i++)
            tree[n+i] = arr[i];

        for(int i=n-1;i>0;i--)
            tree[i] = Math.min(tree[2*i], tree[2*i+1]);
    }

    static void printArrayTree() {
        for(int i=1;i<tree.length;i++)
            System.out.print(tree[i]+" ");
        System.out.println();
    }

    static class Node{
        int data;
        Node left,right;

        Node(int d){
            data=d;
        }
    }

    static Node buildNode(int arr[]){
        List<Node> nodes = new ArrayList<>();

        for(int x:arr)
            nodes.add(new Node(x));

        while(nodes.size()>1){

            List<Node> next = new ArrayList<>();

            for(int i=0;i<nodes.size();i+=2){

                Node left = nodes.get(i);
                Node right = nodes.get(i+1);

                int win = Math.min(left.data,right.data);

                Node parent = new Node(win);
                parent.left = left;
                parent.right = right;

                next.add(parent);
            }

            nodes = next;
        }

        return nodes.get(0);
    }

    static void preorder(Node root){
        if(root==null) return;

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[]) {

        int arr[] = {5,3,8,2,6,7,4,1};

        System.out.println("Array Based Winner Tree:");
        buildArray(arr);
        printArrayTree();
        System.out.println("Winner: "+tree[1]);

        System.out.println("\nNode Based Winner Tree:");
        Node root = buildNode(arr);
        System.out.println("Winner: "+root.data);
        System.out.print("Preorder Traversal: ");
        preorder(root);
    }
}
