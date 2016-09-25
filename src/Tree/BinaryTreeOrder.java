package Tree;


import java.util.Stack;

/**
 * Created by lwy on 2016/9/16.
 */
public class BinaryTreeOrder {
    //递归先序
    private static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //非递归先序，先放入左子树，再右子树
    private static void preOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null)
                    stack.push(head.right);
                if (head.left != null)
                    stack.push(head.left);
            }
        }
        System.out.println();
    }

    //递归中序
    private static void midOrderRecur(TreeNode head) {
        if (head == null)
            return;
        midOrderRecur(head.left);
        System.out.print(head.val);
        midOrderRecur(head.right);
    }

    //非递归中序，每次先放入节点的左链
    private static void midOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    //递归后序
    private static void postOrderRecur(TreeNode head) {
        if (head == null)
            return;
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.val);
    }

    //非递归后序，用一个栈存中右左的遍历结果，pop出来之后就是左中右
    private static void postOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> out = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                out.push(head);
                if (head.left != null)
                    s1.push(head.left);
                if (head.right != null)
                    s1.push(head.right);
            }

            while (!out.isEmpty()) {
                System.out.print(out.pop().val + " ");
            }
            System.out.println();
        }
    }

    private static void postOrderUnRecur2(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            TreeNode p = null;
            while (!stack.isEmpty()) {
                p = stack.peek();
                if (p.left != null && head != p.left && head != p.right) {
                    stack.push(p.left);
                } else if (p.right != null && head != p.right) {
                    stack.push(p.right);
                } else {
                    System.out.print(stack.pop().val + " ");
                    head = p;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode rightleft = new TreeNode(3);
        root.right = right;
        right.left = rightleft;
        System.out.println("preOrderRecur:");
        preOrderRecur(root);
        System.out.println("\npreOrderUnRecur:");
        preOrderUnRecur(root);
        System.out.println("midOrderRecur:");
        midOrderRecur(root);
        System.out.println("\nmidOrderUnRecur:");
        midOrderUnRecur(root);
        System.out.println("postOrderRecur:");
        postOrderRecur(root);
        System.out.println("\npostOrderUnRecur:");
        postOrderUnRecur(root);
    }
}
