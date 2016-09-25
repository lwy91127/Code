package Tree;

/**
 * Created by lwy on 2016/9/24.
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class IsSubTree {
    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val)
                result = find(root1, root2);
            if (!result)
                result = isSubtree(root1.left, root2);
            if (!result)
                result = isSubtree(root1.right, root2);
        }
        return result;
    }

    private boolean find(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null)
            return false;
        if (root2 == null)
            return true;
        if (root1.val != root2.val)
            return false;
        return find(root1.left, root2.left) && find(root1.right, root2.right);
    }
}
