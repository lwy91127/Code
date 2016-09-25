package HuaWei;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/6.
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
 * 以8个数(N=7)为例:0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 * 输入例子:
 * 8
 * 输出例子:
 * 6
 */
public class DeleteNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            boolean[] delete = new boolean[n];
            int total = 0;
            int count = 0;
            int i = 0;
            while (total != n - 1) {
                if (!delete[i])
                    count++;
                if (count == 3) {
                    delete[i] = true;
                    total++;
                    count = 0;
                }
                i = (i == n - 1) ? 0 : i + 1;
            }
            for (int j = 0; j < n; j++) {
                if (!delete[j])
                    System.out.println(j);
            }
        }
    }
}
