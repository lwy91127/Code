package Others;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lwy on 2016/4/22.
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!= t.length()) {
            return false;
        }
        char[] maps = new char[256];
        char[] mapt = new char[256];
        for(int i = 0;i<s.length();i++){
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if(maps[ss] == 0 && mapt[tt] == 0){
                maps[ss] = tt;
                mapt[tt] = ss;
            }else{
                if(maps[ss] != tt || mapt[tt] != ss )
                    return false;
            }
        }

        return true;
    }

    @Test
    public void test(){
        System.out.println(isIsomorphic("foo","add"));
    }
}
