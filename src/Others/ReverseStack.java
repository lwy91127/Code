package Others;

import Utils.MyUtils;

/**
 * Created by lwy on 2016/9/16.
 * 一个栈依次压入1,2,3,4,5那么从栈顶到栈底分别为5,4,3,2,1。将这个栈转置后，从栈顶到栈底为1,2,3,4,5，
 * 也就是实现了栈中元素的逆序，请设计一个算法实现逆序栈的操作，但是只能用递归函数来实现，而不能用另外的数据结构。
 * 给定一个栈Stack以及栈的大小top，请返回逆序后的栈。
 */
public class ReverseStack {
    private static int[] reverseStackRecursively(int[] stack, int top) {
        if (top != 0) {
            int cur = stack[--top];
            reverseStackRecursively(stack, top);
            insertIntoBottom(stack, cur, top);
        }

        return stack;
    }

    private static void insertIntoBottom(int[] stack, int cur, int top) {
        if (top == 0) {
            int temp = stack[top];
            stack[top++] = cur;
            stack[top] = temp;
        } else {
            int current = stack[top--];
            insertIntoBottom(stack, current, top++);
            stack[top] = current;
        }
    }

    public static void main(String[] args) {
        int[] stack = {1, 2, 3, 4, 5};
        MyUtils.printVector(reverseStackRecursively(stack, 5));
    }
}
