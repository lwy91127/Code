package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/4/1.
 */
public class GetNodeSum {
    public int getSum(TreeNode head) {
        if (head == null)
            return 0;
        int height = 0;
        TreeNode temp = head;
        while (temp != null) {
            height++;
            temp = temp.left;
        }
        System.out.println(height);
        return getCurrSum(head, 1, height);
    }

    private int getCurrSum(TreeNode head, int currlayer, int height) {
        if (currlayer == height)
            return 1;
        if (getHeight(head.right) == height - currlayer) {
            return (1 << getHeight(head.left)) + getCurrSum(head.right, ++currlayer, height);
        } else {
            return (1 << getHeight(head.right)) + getCurrSum(head.left, ++currlayer, height);
        }
    }

    private int getHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            node = node.left;
            height++;
        }
        return height;
    }

    @Test
    public void test() {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        System.out.println(getSum(t));
    }
}
