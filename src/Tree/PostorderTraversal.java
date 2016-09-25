package Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1].
 * Created by lwy on 2016/5/31.
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> result = new ArrayList<>();
        //recursiveMethod(root,result);
        iterativelyMethod(root, result);
        return result;
    }

    private void recursiveMethod(TreeNode root, List<Integer> result) {
        if (root.left != null)
            recursiveMethod(root.left, result);
        if (root.right != null)
            recursiveMethod(root.right, result);
        result.add(root.val);
    }

    private void iterativelyMethod(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                output.push(root);
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        while (!output.isEmpty()) {
            result.add(output.pop().val);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode rightleft = new TreeNode(3);
        root.right = right;
        right.left = rightleft;
        System.out.println(postorderTraversal(root));
    }
}
