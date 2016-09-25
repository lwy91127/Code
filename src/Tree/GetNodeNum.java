package Tree;

/**
 * Created by lwy on 2016/9/17.
 * 求二叉树中的节点个数
 * 递归解法：
 * （1）如果二叉树为空，节点个数为0
 * （2）如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
 */
public class GetNodeNum {
    private static int getNodeNum(TreeNode node) {
        if (node == null)
            return 0;
        return getNodeNum(node.left) + getNodeNum(node.right) + 1;
    }
}
