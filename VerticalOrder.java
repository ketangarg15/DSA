import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class VerticalOrder {
    public static void verticalView(TreeNode root) {

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair p = q.poll();
            TreeNode node = p.node;
            int hd = p.hd;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.val);

            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }

        for (List<Integer> list : map.values()) {
            System.out.println(list);
        }
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

        Scanner sc = new Scanner(System.in);

        TreeNode root = buildTree(sc);

        verticalView(root);
    }
}