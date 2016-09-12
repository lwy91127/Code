package Tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 * Created by lwy on 2016/6/12.
 */
public class RootToLeafSum {
    public int sumNumbers(TreeNode root){
        return dfs(root,0);
    }

    public int dfs(TreeNode root,int curNum){
        if(root == null)
            return 0;
        curNum = curNum*10 + root.val;
        if(root.left == null && root.right == null)
            return curNum;
        return dfs(root.left,curNum) + dfs(root.right,curNum);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(sumNumbers(root));
    }
}
