package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/4/1.
 */
public class GetUpMedian {

    private int getMedian(int[] arr1,int start1,int end1,int[] arr2,int start2,int end2){
        if(start1 == end1){
            return Math.min(arr1[start1],arr2[start2]);
        }
        int isjishu = ((end1-start1+1)&1)^1;
        if(arr1[(end1+start1)/2] > arr2[(end2+start2)/2]){
            return getMedian(arr1,start1,(end1+start1)/2,arr2,(start2+end2)/2+isjishu,end2);
        }else if(arr1[(end1+start1)/2] < arr2[(end2+start2)/2]){
            return getMedian(arr1,(end1+start1)/2+isjishu,end1,arr2,start2,(start2+end2)/2);
        }else{
            return arr1[(start1+end1)/2];
        }
    }

    public int getKthMinNum(int[] arr1,int[] arr2,int kth){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] shortarr = len1>len2?arr2:arr1;
        int[] longarr = len1>len2?arr1:arr2;
        if(kth <= shortarr.length){
           return getMedian(arr1,0,kth-1,arr2,0,kth-1);
        }
        if(kth > longarr.length){
            int sstart = kth - longarr.length-1;
            int send = shortarr.length -1;
            int lstart = kth - shortarr.length-1;
            int lend = longarr.length -1;
            if(shortarr[sstart] > longarr[lend])
                return shortarr[sstart];
            if(longarr[lstart] > shortarr[send])
                return longarr[lstart];
            return getMedian(shortarr,sstart+1,send,longarr,lstart+1,lend);
        }
        if(longarr[kth - shortarr.length - 1] > shortarr[shortarr.length - 1]){
            return longarr[kth - shortarr.length - 1];
        }
        return getMedian(shortarr,0,shortarr.length - 1,longarr,kth-shortarr.length,kth -1);
    }

    @Test
    public void test(){
        int[] arr1 = {3,7,7,7,9,10,12,12,13,15,17,17,17};
        int[] arr2 = {10,14,28,30,31,43};
        System.out.println(getKthMinNum(arr1,arr2,13));
    }
}
