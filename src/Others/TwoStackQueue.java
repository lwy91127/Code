package Others;

import java.util.Stack;

/**
 * Created by lwy on 2016/3/12.
 */
class Queue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push((stack1.pop()));
            }
        }
        return stack2.pop();
    }
}

public class TwoStackQueue {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.push(2);
        q.push(1);

        q.push(3);
        q.push(4);
        System.out.println(q.pop());
        System.out.println(q.pop());
        q.push(5);
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}