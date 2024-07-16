package hash;


/*
128. 最长连续序列
中等

给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */


import com.oracle.webservices.internal.api.databinding.DatabindingMode;

import java.util.HashMap;

public class hashtest03 {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};

        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int num:nums) map.put(num,1);

        for(int num:nums){
            int cur =1;
            int tem = num+1;
            while(map.containsKey(tem)){
                if(map.get(tem) ==1){
                   cur +=1;
                   tem +=1;
                }
                else{
                    cur += map.get(tem+1);
                    map.put(num,cur);
                    break;
                }

                max =Math.max(max,cur);
            }

        }
//        for(int num : nums){
//            segment tem = new segment(0,true);
//            int left = 0;
//            if(map.containsKey(num-1) && map.get(num-1).isleft())
//                left = map.get(num-1).getLen();
//
//            int right =0;
//            if(map.containsKey(num+1) && !map.get(num+1).isleft())
//                right = map.get(num+1).getLen();
//            System.out.println("left=" + left + "right=" +right);
//            int leng = left + right +1;
//            max = Math.max(max,leng);
//            tem.setLen(leng);
//            map.put(num+right,tem);
//            System.out.println(tem.toString());
//            tem.setIsleft(false);
//            map.put(num-left,tem);
//            System.out.println(tem.toString());
//
//        }
        System.out.println(max);
    }
}

class segment{
    public int len;
    public boolean isleft;

    segment(int len, boolean isleft){
        this.len = len;
        this.isleft = isleft;
    }
    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public boolean isleft() {
        return isleft;
    }

    public void setIsleft(boolean isleft) {
        this.isleft = isleft;
    }

    @Override
    public String toString() {
        return "segment{" +
                "len=" + len +
                ", isleft=" + isleft +
                '}';
    }
}
















