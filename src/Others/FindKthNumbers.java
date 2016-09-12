package Others;

import Utils.MyUtils;
import org.junit.Test;

/**
 * Created by lwy on 2016/4/3.
 */
public class FindKthNumbers {
    public int[] findKthNumbers(int[] A, int n, int k){
        if(k < 1 || k > n)
            return A;
        int[] heap = new int[k];
        for(int i = 0;i < k;i++){
            heapInsert(heap,A[i],i);
        }
        for(int j = k;j<A.length;j++){
            if(A[j] < heap[0]){
                heap[0] = A[j];
                heapify(heap,0,k);
            }
        }
        return heap;
    }

    private void heapify(int[] heap, int index, int heapsize) {
        int left = index * 2 - 1;
        int right = index * 2 + 1;
        int lagest = index;
        while(left < heapsize){
            if(heap[left] > heap[index]){
                lagest = left;
            }
            if(right < heapsize && heap[right] > heap[index])
                lagest = right;
            if(lagest != index)
                swap(heap,index,lagest);
            else
                break;
            index = lagest;
            right = index * 2 - 1;
            left = index * 2 + 1;
        }
    }

    private void heapInsert(int[] heap, int value, int index) {
        heap[index] = value;
        int parent = (index - 1)/2;
        while(index != 0){
            if(heap[parent] < heap[index]){
                swap(heap,parent,index);
                index = parent;
            }else
                break;
        }
    }

    private void swap(int[] heap, int parent, int index) {
        int temp = heap[parent];
        heap[parent] = heap[index];
        heap[index] = temp;
    }

    @Test
    public void test(){
        int[] a = {1,2,4,3,5,6,9};
        int[] res = findKthNumbers(a,7,4);
        MyUtils.printVector(res);
    }
}
