package String;

/**
 * Created by lwy on 2016/9/7.
 * <p>
 * 请你实现一个简单的字符串替换函数。原串中需要替换的占位符为"%s",请按照参数列表的顺序一一替换占位符。若参数列表的字符数大于占位符个数。则将剩下的参数字符添加到字符串的结尾。
 * 给定一个字符串A，同时给定它的长度n及参数字符数组arg，请返回替换后的字符串。保证参数个数大于等于占位符个数。保证原串由大小写英文字母组成，同时长度小于等于500。
 * 测试样例：
 * "A%sC%sE",7,['B','D','F']
 * 返回："ABCDEF"
 */
public class StringFormat {
    public static String formatString(String A, int n, char[] arg, int m) {
        StringBuilder sb = new StringBuilder();
        String[] strings = A.split("%s");
        int leave = arg.length - strings.length;
        int i = 0;
        for (String s : strings) {
            sb.append(s);
            if (i < arg.length)
                sb.append(arg[i++]);
        }
        while (leave > 0) {
            sb.append(arg[i++]);
            leave--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        char[] arg = {'B', 'D'};
        System.out.println(formatString("A%sC%sE", 7, arg, 3));
    }
}
