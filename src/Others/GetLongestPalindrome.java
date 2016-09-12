package Others;

import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.runtime.regexp.joni.constants.StackPopLevel;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;
import org.junit.Test;

import java.util.*;

/**
 * Created by lwy on 2016/4/3.
 */
@SuppressWarnings("Duplicates")
public class GetLongestPalindrome {

    //时间复杂度O(n_2)
    public int getLongestPalindrome(String str,int n){
        str = preDealStr(str);
        int result = 0;
        for(int i = 1;i<str.length()-1;i++){
            int left = i-1;
            int right = i+1;
            int count = 1;
            while(left >=0 && right <= str.length() - 1){
                if(str.charAt(left) == str.charAt(right)){
                    count += 2;
                    left--;
                    right++;
                }else
                    break;
            }
            if(count > result)
                result = count;
        }
        return result/2;
    }

    //Mancher优化 O(n)
    public int betterGetLongestPalidrome(String str,int n ){
        str = preDealStr(str);
        System.out.println(str+ " "+str.length());
        int index = -1;
        int pR = -1;
        int result = Integer.MIN_VALUE;
        int[] pArr = new int[str.length()];
        for(int i = 0;i != str.length();i++){
            if(pR > i){
                if(pR - i > pArr[2*index - i]){
                    pArr[i] = pArr[2*index - i];
                }else
                    pArr[i] = pR - i;
            }else{
                pArr[i] = 1;
            }
            while(i+pArr[i] < str.length() && i-pArr[i] >-1){
                if(str.charAt(pArr[i] + i) == str.charAt(i - pArr[i]))
                    pArr[i]++;
                else
                    break;
            }
            if(i+pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            result = Math.max(result,pArr[i]);
        }
        return result-1;
    }

    //进阶末尾添加最短字符串使成为整体回文
    public String addShortStr(String str,int n){
        if(str == null || str.length() == 0)
            return null;
        str = preDealStr(str);
        int index = -1;
        int pR = -1;
        int[] pArr = new int[str.length()];
        int maxEnd = -1;
        for(int i = 0;i != str.length();i++){
            if(pR > i){
                if(pR - i > pArr[2*index - i]){
                    pArr[i] = pArr[2*index - i];
                }else
                    pArr[i] = pR - i;
            }else{
                pArr[i] = 1;
            }
            while(i+pArr[i] < str.length() && i-pArr[i] >-1){
                if(str.charAt(pArr[i] + i) == str.charAt(i - pArr[i]))
                    pArr[i]++;
                else
                    break;
            }
            if(i+pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            if(pR == str.length()){
                maxEnd = pArr[i];
                break;
            }
        }
        System.out.println(maxEnd);
        char[] result = new char[n - maxEnd + 1];
        for(int i = 0;i<result.length;i++){
            result[result.length - 1 - i] = str.charAt(2*i + 1);
        }
        return String.valueOf(result);
    }

    private String preDealStr(String str){
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for(int i = 0;i < str.length();i++){
            sb.append(str.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }


    @Test
    public void test(){
    }
}
