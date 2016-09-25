package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lwy on 2016/9/17.
 * 分层遍历二叉树（按层次从上往下，从左往右）
 */
public class LevelTraverse {
    private static void levelTraverse(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            System.out.print(n.val);
            if (n.left != null)
                queue.offer(n.left);
            if (n.right != null)
                queue.offer(n.right);
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftleft = new TreeNode(4);
        TreeNode rightright = new TreeNode(5);
        head.left = left;
        head.right = right;
        left.left = leftleft;
        right.right = rightright;
        levelTraverse(head);
    }
}
