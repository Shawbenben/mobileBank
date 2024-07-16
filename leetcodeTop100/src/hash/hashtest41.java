package hash;

import java.util.Arrays;
import java.util.HashSet;

/*
41. 缺失的第一个正数
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class hashtest41 {
    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        int re = 1;
        int swap = 0;
        int len = nums.length;

        for(int i=0;i<len;i++ ){
            System.out.println(Arrays.toString(nums));
            if(nums[i] == i+1) continue;

            if(nums[i]-1>=0 && nums[i]<=len){
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[nums[i]-1] = temp;
                //swap(nums,nums[i]-1,i);

                i--;
            }
        }
        for(int num: nums){
            if(num !=re++) break;
        }
        re -= 1;

//        HashSet<Integer> set = new HashSet<>();
//
//        for(int num:nums){
//            set.add(num);
//        }
//        boolean bool = true;
//        int re = 1;
//        while(bool){
//            if(set.contains(re)) re++;
//            else{
//                break;
//            }
//        }

        System.out.println(re);
    }
}
