package hash;

import java.util.*;

public class hashlearn {
    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // strs[0] = strs[0] +(char)('a'+1);
        HashMap<String,Integer> map =new HashMap<>();
        int count = 0;
        for(String str : strs){
            str = strAd(str);
            if(!map.containsKey(str)) map.put(str,count++);
        }

        List<List<String>> answer =new ArrayList<>();
        for(int i =0;i<map.size();i++){
            List<String> list = new LinkedList<>();
            answer.add(list);
        }

        for(String str : strs){
            answer.get(map.get(strAd(str))).add(str);
        }
        System.out.println(Arrays.deepToString(answer.toArray()));
    }
    public static String strAd(String string){
        int[] alphabet = new int[26];
        int len = string.length();
        for(int i =0;i<len;i++){
            int a =string.charAt(i)-'a';
            alphabet[a]++;
        }
        String str = "";
        for(int i=0;i<26;i++){
            if(alphabet[i] == 0) continue;
            else{
                for(int j=0;j<alphabet[i];j++) str = str + (char)('a' + i);
            }
        }
        return str;
    }
}
