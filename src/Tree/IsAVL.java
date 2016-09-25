package Tree;

/**
 * Created by lwy on 2016/9/19.
 * 判断平衡二叉树
 */
public class IsAVL {
    private static boolean isAvl(TreeNode node) {
        if (node == null)
            return true;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if (isAvl(node.left) && isAvl(node.right) && Math.abs(leftHeight - rightHeight) <= 1) {
            return true;
        } else {
            return false;
        }
    }

    private static int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftleft = new TreeNode(4);
        TreeNode leftright = new TreeNode(5);
        TreeNode leftleftleft = new TreeNode(6);
        head.left = left;
        head.right = right;
        left.left = leftleft;
        left.right = leftright;
        leftleft.left = leftleftleft;
        System.out.println(isAvl(head));
    }
}
