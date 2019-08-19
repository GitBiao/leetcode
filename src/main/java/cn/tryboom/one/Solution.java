package cn.tryboom.one;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        if(nums1 == null){
            //考虑有一个数组为空的情况
            return oneArrayMedian(nums2);
        }
        if(nums2 == null){
            //考虑有一个数组为空的情况
            return oneArrayMedian(nums1);
        }
        //数组合并
        List<Integer> collect = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        collect.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        //排序并取中位数
        return oneArrayMedian(collect.stream().sorted().mapToInt(Integer::intValue).toArray());
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


    public static void main(String[] args) {
        double d = (2+3)/2D;
        System.out.println(d);
    }

}
