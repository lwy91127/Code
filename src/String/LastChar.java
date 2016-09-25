package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lwy on 2016/9/14.
 * 正在挑战一个CrackMe的你，把需要填写的前面几位密码都正确猜出了，可是这最后一位密码，好像藏得有点深。
 * CrackMe的作者还挑衅般的在里面藏了个.tar.gz文件，解压缩出来，里面写道 你要的最后一个字符就在下面这个字符串里，
 * 这个字符是下面整个字符串中第一个只出现一次的字符。（比如，串是abaccdeff，那么正确字符就是b了）
 * 然而下面给出来的字符串好像太长太长了，单靠人力完全无法找出来。
 * 于是，你需要写一个程序代劳了。输入文件体积较大，请使用一些快速的输入输出手段，
 * 不推荐使用cin/cout，对Java并不推荐使用Scanner直接读写。
 * <p>
 * 输入例子:
 * 2
 * abaccdeff
 * testonline
 * <p>
 * 输出例子:
 * b
 * s
 */
public class LastChar {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.valueOf(reader.readLine());
            for (int i = 0; i < n; i++) {
                String str = reader.readLine();
                Map<Character, Integer> map = new LinkedHashMap<>();
                for (char c : str.toCharArray()) {
                    if (!map.containsKey(c))
                        map.put(c, 0);
                    else
                        map.remove(c);
                }
                System.out.println(map.entrySet().iterator().next().getKey());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
