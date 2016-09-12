package Others;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwy on 2016/2/29.
 */
public class ReplaceString {
    public static String replaceSpace(StringBuffer str){
        List<Integer> list = new ArrayList<>();

        return str.toString().replace(" ","%20");
    }


    @Test
    public void testMain(){
        System.out.println(replaceSpace(new StringBuffer("We  Are Happy")));
    }
}
