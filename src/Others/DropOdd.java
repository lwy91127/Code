package Others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lwy on 2016/9/11.
 *
 * 对于一个由0..n的所有数按升序组成的序列，我们要进行一些筛选，每次我们取当前所有数字中从小到大的第奇数位个的数，并将其丢弃。
 * 重复这一过程直到最后剩下一个数。请求出最后剩下的数字。
 输入例子:
 500

 输出例子:
 255
 */
public class DropOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i <= n ; i++) {
                l.add(i);
            }
            while(l.size() != 1) {
                for (int i = 0; i < l.size(); i++) {
                    l.remove(i);
                }
            }
            System.out.println(l.get(0));
        }
    }
}
