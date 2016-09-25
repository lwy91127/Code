package Others;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lwy on 2016/4/5.
 */
public class LRUCache {
    class Node {
        Node pre;
        Node next;
        Integer val;
        Integer key;

        Node(Integer key, Integer val) {
            this.key = this.val;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    int cap;

    public LRUCache(int cap) {
        this.cap = cap;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if (n != null) {
            n.pre.next = n.next;
            n.next.pre = n.pre;
            appendTail(n);
            return n.val;
        }
        return -1;
    }

    public void set(int key, int value) {
        Node n = map.get(key);
        if (n != null) {
            n.val = value;
            map.put(key, n);
            n.pre.next = n.next;
            n.next.pre = n.pre;
            appendTail(n);
            return;
        } else {
            if (map.size() == cap) {
                Node temp = head.next;
                head.next = head.next.next;
                head.next.pre = head;
                map.remove(temp.key);
            }
            n = new Node(key, value);
            appendTail(n);
            map.put(key, n);
        }
    }

    private void appendTail(Node n) {
        n.next = tail;
        n.pre = tail.pre;
        tail.pre.next = n;
        tail.pre = n;
    }


}
