package String;

import org.junit.Test;

/**
 NO.38
 The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 * Created by lwy on 2016/6/15.
 */
public class CountAndSay {
    public String countAndSay(int n){
        if(n <= 0) return "";
        String init = "1";
        int count ;

        for(int i = 1;i<n;i++){
            count = 1;
            StringBuilder sb = new StringBuilder();
            for(int j = 1;j<init.length();j++){

                if(init.charAt(j-1) == init.charAt(j)){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(init.charAt(j-1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(init.charAt(init.length() - 1));
            init = sb.toString();
        }
        return init;
    }

    @Test
    public void test(){
        System.out.println(countAndSay(12));
    }
}
