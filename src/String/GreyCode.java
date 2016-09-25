package String;

import Utils.MyUtils;

/**
 * Created by lwy on 2016/9/8.
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，请编写一个函数，
 * 使用递归的方法生成N位的格雷码。给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 * 测试样例：1
 * 返回：["0","1"]
 */
public class GreyCode {
    public static String[] getGray(int n) {
        int m = 1 << n;
        String[] strings = new String[m];
        if (n == 1) {
            strings[0] = "0";
            strings[1] = "1";
            return strings;
        }
        String[] temp = getGray(n - 1);
        int j = 0;
        for (int i = 0; i < m; i++) {
            if (i < m / 2) { //对结果数组分成两半
                strings[i] = "0" + temp[j++];
            } else {
                strings[i] = "1" + temp[--j];
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        MyUtils.printVector(getGray(3));
    }
}
