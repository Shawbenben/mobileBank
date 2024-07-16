package StringLearn;

import java.util.Arrays;

public class reverseWords {
    public static void main(String[] args) {
        String s = "the sky    is blue";
        String[] strs = s.split(" ");
        int[][] arrs = new int[2][2];
        Arrays.fill(arrs[0],1);
        int[] prices = new int[]{3,5,6,7,1,2,4,7};
        int max = 0;
        for(int i=prices.length-1;i>0;i--){
            max=Math.max(max,prices[i]-Arrays.stream(Arrays.copyOfRange(prices,0,i)).min().getAsInt());
        }
        
        // Arrays 提取 最大值和最小值
        System.out.println(Arrays.stream(Arrays.copyOfRange(arrs[0],0,1)).max().getAsInt());
        int upper = Arrays.stream(arrs[0]).max().getAsInt();
        System.out.println(Arrays.stream(arrs[0]).min());
        System.out.println(Arrays.deepToString(arrs));
        System.out.println(Arrays.deepToString(strs));
        String re = new String();
        int len = strs.length;
        for(int i =len-1;i>=0;i--){
            System.out.println(strs[i]);

            if(strs[i].equals("")) continue;
            System.out.println(re);
            re.concat(strs[i]);
        }

        System.out.println(re);
    }
}
