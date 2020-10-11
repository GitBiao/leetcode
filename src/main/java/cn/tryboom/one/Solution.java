package cn.tryboom.one;


/**
 *         给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 *         请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 *         你可以假设 nums1 和 nums2 不会同时为空。
 *
 *         示例 1:
 *
 *         nums1 = [1, 3]
 *         nums2 = [2]
 *
 *         则中位数是 2.0
 *         示例 2:
 *
 *         nums1 = [1, 2]
 *         nums2 = [3, 4]
 *
 *         则中位数是 (2 + 3)/2 = 2.5
 */

public class Solution {
    //两个数组取中位数，无非是将数组合并后排好序，取中间的数。
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        SeqList a = new SeqList(nums1);
        SeqList b = new SeqList(nums2);
        SeqList c = new SeqList(new int[a.array.length + b.array.length]);
        Combine cob=new Combine();
        cob.Combine(a, b, c);
        for (int i=0;i<c.array.length ;i++){
            System.out.println(c.array[i]);
        }
        return  oneArrayMedian(c.array);
    }

    private double oneArrayMedian(int[] array){
        if( array.length%2 == 0 ){
            //偶数个
            int i = array.length / 2;
            return (array[i - 1] + array[i]) / 2D;
        }else {
            //奇数个,直接取中位数
            return array[ (array.length/2 + array.length%2) - 1];
        }
    }


}

class SeqList {
    public int[] array;
    public int last;
    public SeqList(int[] array) {
        this.array=array;
        if(array!=null) {//判断是否为空
            last=array.length;
        }
    }
}
class Combine {
    public void Combine(SeqList A,SeqList B,SeqList C) {
        int a=0,b=0,c=0;
        while(a<A.last&&b<B.last) {
            if(A.array[a]<B.array[b]) {
                C.array[c++]=A.array[a++];
            }else {
                C.array[c++]=B.array[b++];
            }
        }
        while(a<A.last) {
            C.array[c++]=A.array[a++];
        }
        while(b<B.last) {
            C.array[c++]=B.array[b++];
        }
        C.last=c;
    }
}

