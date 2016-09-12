package Tree;

/**
 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Created by lwy on 2016/6/15.
 */
public class MaxDepth {
    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }


}
