package HuaWei;

import java.util.Scanner;

/**
 * Created by lwy on 2016/8/13.
 */
public class HexToDec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String hex = scanner.nextLine().substring(2);
            int n = hex.length() - 1;
            int result = 0;
            for(char c: hex.toCharArray()){
                int x;
                if(c >= 'A' && c <= 'F'){
                    x = c - 'A' + 10;
                }
                else{
                    x = c - '0';
                }
                result += (int) (Math.pow(16,n) * x);
                n--;
            }
            System.out.println(result);
        }
    }
}
