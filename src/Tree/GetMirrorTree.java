package Tree;

/**
 * Created by lwy on 2016/9/24.
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class GetMirrorTree {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
