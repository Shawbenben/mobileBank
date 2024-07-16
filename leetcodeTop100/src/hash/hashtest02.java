package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class hashtest02 {
    public static void main(String[] args) {
        String[] quires ={"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        String[] wrodlist ={"KiTe","kite","hare","Hare"};
        System.out.println(Arrays.deepToString(spellchecker(wrodlist,quires)));
    }
//    当查询完全匹配单词列表中的某个单词（区分大小写）时，应返回相同的单词。
//    当查询匹配到大小写问题的单词时，您应该返回单词列表中的第一个这样的匹配项。
//    当查询匹配到元音错误的单词时，您应该返回单词列表中的第一个这样的匹配项。
//    如果该查询在单词列表中没有匹配项，则应返回空字符串。
    public static String[] spellchecker(String[] wordlist, String[] queries){
        String[] answer =new String[queries.length];
        int len = wordlist.length;
        Set<String> set = new HashSet<>();
        for(int i=0;i<len;i++){
            set.add(wordlist[i]);
        }
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0;i<len;i++) {
            String str = wordlist[i].toLowerCase();
            //map2.put(str, map2.getOrDefault(str, i));等价
            map.putIfAbsent(str,i);
        }

        Set<String> keys = map.keySet();
        for(String key:keys){
            System.out.print(key + "：" + map.get(key)+"   ");
        }
        System.out.println();

        for(int i = 0;i<len;i++){
            String str = wordlist[i].toLowerCase();
            str = cutVowel(str);
            map.put(str, map.getOrDefault(str,i));
        }
        int c =0;
        Set<String> keys2 = map.keySet();
        for(String key:keys2){
            System.out.print(key + "：" + map.get(key)+"   ");
        }
        System.out.println();
//        "kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"
        for(String string:queries){

            if(set.contains(string)){
                answer[c++] = string;
            } else if (map.containsKey(string.toLowerCase())){
                answer[c++] = wordlist[map.get(string.toLowerCase())];
            } else if (map.containsKey(cutVowel(string.toLowerCase()))) {
                answer[c++] = wordlist[map.get(cutVowel(string.toLowerCase()))];
            }else{
                answer[c++] = "";
            }
        }
        return answer;
    }

    public static String cutVowel(String str){

//        str=str.replace('a','0');
//        str=str.replace('e','0');
//        str= str.replace('i','0');
//        str=str.replace('o','0');
//        str= str.replace('u','0');
        return str.replace('a','0').replace('e','0').replace('i','0').replace('o','0').replace('u','0');
    }
}
//["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
//[kite, kite, KiTe, Hare, hare, , , kite, , kite]
//{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
//String[] wrodlist ={"KiTe","kite","hare","Hare"};