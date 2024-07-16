package hash;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class hashtest01 {
    public static void main(String[] args) {
       int[] arr = new int[]{2,4,8,16,-3,-6};
        System.out.println(Arrays.toString(arr));
        // Arrays.deepToString(),是可以直接打印高维数组
        System.out.println(canReorderDoubled(arr));
    }
    public static boolean canReorderDoubled(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int a : arr) map.put(a, map.getOrDefault(a,0)+1);

        Integer[] arrTemp = new Integer[arr.length];
        for(int i=0;i<arr.length;i++) arrTemp[i]=arr[i];
        Comparator<Integer> comparator =Comparator.comparingInt(Math::abs);
        Arrays.sort(arrTemp,comparator);

        for(int i=0;i<arr.length;i++){
            int x = arrTemp[i];

            if(map.getOrDefault(x,0)<=0) continue;

            if(map.getOrDefault(2*x,0)<=0) return false;
            else {
                map.put(x,map.get(x)-1);
                map.put(2*x,map.get(2*x)-1);
            }
        }


        return true;
    }
}

