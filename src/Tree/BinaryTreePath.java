package Tree;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwy on 2016/3/24.
 */
public class BinaryTreePath {
    public List<String> binaryTreePath(TreeNode root){
        List<String> res = new ArrayList<>();
        help(res,root,new StringBuilder());
        return res;
    }

    private void help(List<String> res, TreeNode root, StringBuilder stringBuilder) {
        if(root == null)
            return;
        int len = stringBuilder.length();
        stringBuilder.append(root.val);
        if(root.left == null && root.right == null){
            System.out.println(stringBuilder.toString());
            res.add(stringBuilder.toString());
            stringBuilder.setLength(len);
            System.out.println(stringBuilder.toString());
            return;
        }
        stringBuilder.append("->");
        System.out.println(stringBuilder.toString());
        help(res,root.left,stringBuilder);
        help(res,root.right,stringBuilder);
        stringBuilder.setLength(len);
        System.out.println(stringBuilder.toString());
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        root.right = new TreeNode(3);
        left.right = new TreeNode(5);

        System.out.println(binaryTreePath(root));
    }
}
