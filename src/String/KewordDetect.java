package String;

import Utils.MyUtils;

import java.util.*;

/**
 * Created by lwy on 2016/9/7.
 *
 给定字符串数组A及它的大小n以及关键词数组key及它的大小m，请返回一个排好序的含关键词的字符串序号的列表。保证所有字符串长度小于等于100，关键词个数小于等于100，字符串个数小于等于200。保证所有字符串全部由小写英文字符组成。若不存在含关键字的字符串，请返回一个只含-1的数组。
 测试样例：
 ["nowcoder","hello","now"],3,["coder",now],2
 返回：[0,2]
 */
public class KewordDetect {
    public static int[] containKeyword(String[] A,int n,String[] keys,int m){
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(String k:keys){
                if(A[i].contains(k)){
                    res.add(i);
                    break;
                }
            }
        }
        if(res.isEmpty())
            return new int[]{-1};
        int[] result = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] a = {"nowcoder","hello","now"};
        String[] k = {"coder","now"};
        MyUtils.printVector(containKeyword(a,3,k,2));
    }
}
