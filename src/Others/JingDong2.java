package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/5.
 * <p>
 * <p>
 * 输入输入中有多组测试数据。每组测试数据的第一行为一个整数n（3<=n <=10^6），为首都周围的小山数量，第二行为n个整数，依次表示小山的高度h，（1<=h<=10^9）。
 * 输出对每组测试数据，在单独的一行中输出能相互观察到的岗哨的对数。
 * <p>
 * 样例输入5
 * 1 2 4 5 3
 * <p>
 * 样例输出7
 */
public class JingDong2 {
    public static int getPariNumber(int number, int[] numbers) {
        if (numbers == null || number == 0 || number != numbers.length)
            return 0;
        int amount = 0;
        int tmpJ = 0;
        int previousMax = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                tmpJ = numbers[j];
                if (j == i + 1) {
                    amount++;
                    previousMax = tmpJ;
                } else if (numbers[j] < previousMax) {
                    continue;
                } else if (numbers[j] >= previousMax) {
                    amount++;
                    previousMax = tmpJ;
                }

            }

        }

        return amount;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] numbers = new int[number];
        for (int i = 0; i < number; i++) {
            numbers[i] = sc.nextInt();
        }
        System.out.println(getPariNumber(number, numbers));
    }
}
