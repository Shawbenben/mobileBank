package hash;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MS383_hash {
    public static void main(String[] args) {
        String ransomNote = "affa";
        String magazine ="shfsjaffadd";
        System.out.println(canConstruct(ransomNote,magazine));
    }
    public static boolean canConstruct(String ransomNote,String magazine){
        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : magazine.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Set<Character> keys = map.keySet();
        for(char key :keys){
            System.out.print(key + ":" + map.get(key)+"  ");
        }

        for(char c: ransomNote.toCharArray()){
            if(map.containsKey(c) && map.get(c)>0){
                map.put(c,map.get(c)-1);
            }else{
                return false;
            }
        }
        return true;
    }

}
