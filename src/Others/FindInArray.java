package Others;

/**
 * Created by lwy on 2016/2/29.
 */
public class FindInArray {
    public static boolean Find(int[][] array, int target) {
        int r = array[0].length;
        int c = array.length - 1;
        int i = 0;
        while (c >= 0 && i <= r - 1) {
            if (array[c][i] == target){
                return true;
            }
            else if (array[c][i] > target) {
                --c;
            } else if (array[c][i] < target){
                ++i;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,3,6,7},{2,4,8,9}};
        System.out.println(Find(array,5));
    }
}
