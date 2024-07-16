package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/*
给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class hashtest04 {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 ={-2,-1};
        int[] nums3 ={-1,2};
        int[] nums4 ={0,-2};

        int n = nums1.length;

        Map<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set =new HashSet<>();
        for(Integer i:set) System.out.println(i);
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) System.out.println(iterator.next());
        for(int num1 :nums1)
            for(int num2 : nums2)
                map.put(num1+num2,map.getOrDefault(num1+num2,0)+1);
        int res =0;
        for(int num3 :nums3)
            for(int num4: nums4){
                if(map.containsKey(-num3-num4)) {
                    res += map.get(-num3 - num4);
                    System.out.println("num3: "+num3+" num4: "+num4);
                }
            }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println("map.key:"+ entry.getKey()+"map.value:"+entry.getValue());
        }
        for(Integer i:map.values()){
            int a = Integer.valueOf(i);
        }

        System.out.println(res);
    }
}
