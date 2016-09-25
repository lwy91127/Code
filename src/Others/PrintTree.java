package Others;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by lwy on 2016/3/25.
 */
public class PrintTree {
    public int[][] printTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode last = root;
        TreeNode nlast = last;
        int[] temp = new int[500];
        int[][] res = new int[500][500];
        int i = 0;
        int j = 0;
        while (!queue.isEmpty()) {
            TreeNode q = queue.poll();
            temp[j] = q.val;
            if (q.left != null) {
                queue.add(q.left);
                nlast = q.left;
            }
            if (q.right != null) {
                queue.add(q.right);
                nlast = q.right;
            }
            ++j;
            if (q == last) {
                res[i] = temp;
                temp = new int[500];
                last = nlast;
                ++i;
                j = 0;
            }
        }
        return res;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        root.right = new TreeNode(3);
        left.right = new TreeNode(5);
        int[][] res = printTree(root);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
