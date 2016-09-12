package Others;

import Utils.MyUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lwy on 2016/9/5.
 */
public class JingDong {
    static class Things{
        private String name;
        private int num;

        public Things(String name, int num) {
            this.name = name;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Things{" +
                    "name='" + name + '\'' +
                    ", num=" + num +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = sc.nextInt();
            }
            Arrays.sort(prices);
            MyUtils.printVector(prices);
            Map<String, Integer> things = new HashMap<>();
            for (int i = 0; i < m; i++) {
                String key = sc.next();
                if (!things.containsKey(key))
                    things.put(key, 1);
                else {
                    int newNum = things.get(key) + 1;
                    things.put(key, newNum);
                }
            }
            List<Things> thingses= new ArrayList<>();
            for(Map.Entry entry:things.entrySet()){
                thingses.add(new Things(entry.getKey().toString(), Integer.valueOf(entry.getValue().toString())));
            }
            Collections.sort(thingses, (o1, o2) -> o2.num - o1.num);
            int min = 0;
            int max = 0;
            for(int i = 0;i<thingses.size();i++){
                int num = thingses.get(i).num;
                int price = prices[i];
                int maxprice = prices[n-i-1];
                min += num*price;
                max += num*maxprice;
            }
            System.out.println(min + " " + max);
        }
    }
}
