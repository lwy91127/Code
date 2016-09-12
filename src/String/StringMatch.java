package String;

import java.util.*;

/**
 * Created by lwy on 2016/9/2.
 */
public class StringMatch {
    private static String[] findCoder(String[] A,int n){
        List<Codercls> list = new ArrayList<>();
        int i = 0;
        for(String str:A){
            list.add(new Codercls(str,i++,getCoderNum(str)));
        }
        Collections.sort(list, new Comparator<Codercls>() {
            @Override
            public int compare(Codercls o1, Codercls o2) {
                if(o1.count != o2.count)
                    return o2.count - o1.count;
                else
                    return o1.index - o2.index;
            }
        });
        System.out.println(list);
        String[] result = new String[n];
        for(int j = 0;j<n;j++){
            result[j] = list.get(j).str;
        }
        return result;
    }

    private static int getCoderNum(String str) {
        int count = 0;
        String temp = str.toUpperCase();
        while(temp.contains("CODER")){
            count++;
            temp = temp.substring(temp.indexOf("CODER") + 5);
        }
        return count;
    }

    public static void main(String[] args) {
        String[] A = {"i am a coder","Coder Coder","Code"};
        System.out.println(findCoder(A,3));
    }

    static class Codercls{
        private String str;
        private int index;
        private int count;

        public Codercls(String str,int index, int count) {
            this.str = str;
            this.index = index;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Coder{" +
                    "str='" + str + '\'' +
                    ", index=" + index +
                    ", count=" + count +
                    '}';
        }
    }
}
