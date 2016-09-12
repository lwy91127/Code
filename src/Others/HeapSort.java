package Others;

import Utils.MyUtils;
import org.junit.Test;

/**
 * Created by lwy on 2016/4/5.
 */
public class HeapSort {
    public void sort(int[] A){
        if(A == null && A.length <= 1)
            return;
        buildMaxHeap(A);
        MyUtils.printVector(A);
        for(int i = A.length - 1;i>=1;i--){
            int temp = A[i];
            A[i] = A[0];
            A[0] = temp;
            maxHeap(A,i,0);
            MyUtils.printVector(A);
        }
        MyUtils.printVector(A);
    }

    private void sink(int[] a,int k,int N){
        while(2*k <= N){
            int j = 2 * k;
            if(j < N && a[j]<a[j+1])
                j++;
            if(a[k] < a[j])
                break;
            exch(a,k,j);
            k = j;
        }
    }

    public void sort2(int[] a){
        int N = a.length - 1;
        for(int k = N/2;k>=1;k--){
            sink(a,k,N);
        }
        while(N>0){
            exch(a,1,N--);
            sink(a,1,N);
        }
        MyUtils.printVector(a);
    }

    private void exch(int[] a, int i, int N) {
        int temp = a[N];
        a[N] = a[i];
        a[i] = temp;
    }

    private void buildMaxHeap(int[] A){
        int half = (A.length -1) / 2;
        for(int i = half;i>=0;i--){
            maxHeap(A,A.length,i);
        }
    }

    private void maxHeap(int[] a, int length, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if(left < length && a[left] > a[i]){
            largest = left;
        }
        if(right < length && a[right] > a[largest]){
            largest = right;
        }
        if(i != largest){
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            maxHeap(a,length,largest);
        }
    }

    @Test
    public void test(){
        int[] arr = {3,1,2,5,4,6};
        sort(arr);
    }
}
