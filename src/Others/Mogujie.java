package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/3/31.
 */
public class Mogujie {
    public static int Solution() {
        Scanner sc = new Scanner(System.in);
        int v = Integer.valueOf(sc.nextLine());
        String[] rawOil = sc.nextLine().split(" ");
        int[] oilMap = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            oilMap[i] = Integer.valueOf(rawOil[i - 1]);
        }
        for (int i = 1; i <= v; i++) {

        }
        return -1;
    }

    public static void getExchangeTimes() {
        Scanner sc = new Scanner(System.in);
        int groups = Integer.valueOf(sc.nextLine());
        while (groups > 0) {
            int n = Integer.valueOf(sc.nextLine());
            String[] rawNumbers = sc.nextLine().split(",");
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.valueOf(rawNumbers[i]);
            }
            int excount = 0;
            for (int j = 0; j < n - 1; j++) {
                for (int i = j + 1; i < n; i++) {
                    if (numbers[j] > numbers[i]) {
                        excount++;
                    }
                }
            }
            System.out.println(excount);
            groups--;
        }
    }

    private static void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }

        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (index != largest) {
            exchangeElements(array, index, largest);

            maxHeap(array, heapSize, largest);
        }
    }

    public static void exchangeElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        Solution();
    }
}
