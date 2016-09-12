package HuaWei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by lwy on 2016/8/13.
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            TreeSet<Integer> treeSet = new TreeSet<>();
            while (number > 0) {
                treeSet.add(scanner.nextInt());
                number--;
            }
            for (int i : treeSet) {
                System.out.println(i);
            }
        }
    }
}
