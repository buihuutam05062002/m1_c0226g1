package topic11;

import java.util.Map;
import java.util.TreeMap;

public class Bai2 {
    public static void main(String[] args) {
        String str = "toi dang that tinh toi van rat thich an com toi van rat simp lo";

        str = str.toLowerCase();
        str = str.trim();

        String strs[] = str.split("\s");

        Map<String,Integer> temp = new TreeMap<>();

        for(int i = 0 ; i < strs.length ; i++){
            if(!temp.containsKey(strs[i])){
                temp.put(strs[i],1);
            }
            else{
                temp.put(strs[i], temp.get(strs[i]) + 1);
            }
        }
        for(String key : temp.keySet()){
            System.out.println(key + " " + temp.get(key));
        }



    }
}
