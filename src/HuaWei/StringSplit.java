package HuaWei;

import java.util.Scanner;

/**
 * Created by lwy on 2016/8/13.
 */
public class StringSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String firstStr = scanner.nextLine();
            soutStr(firstStr);
        }
    }

    private static void soutStr(String s){
        while(s.length()>=8){
            System.out.println(s.substring(0, 8));
            s=s.substring(8);
        }
        if(s.length()<8&&s.length()>0){
            s=s+"00000000";
            System.out.println(s.substring(0, 8));
        }
    }

}
