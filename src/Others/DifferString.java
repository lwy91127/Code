package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/3/1.
 */
public class DifferString {
    public static boolean different(String str){
        if(str.length() > 256)
            return false;

        boolean[] char_set = new boolean[256];
        for(int i = 0 ;i < str.length();i++){
            int val = str.charAt(i);
            if(char_set[val])
                return false;
            char_set[val] = true;
        }
        return true;
    }

    @Test
    public void testMain(){
        System.out.println(different("D-5H0F6T%Z?QM9,\72:[A8X! ;YJ#"));
    }
}
