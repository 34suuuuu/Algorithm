import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        
        // 길이가 1인 모든 단어 포함하도록 사전 초기화
        Map<String, Integer> dict = new HashMap<String, Integer>();
        
        char alp = 'A';
        for(int i = 1; i <= ('Z' - 'A') + 1; i++){
            dict.put(String.valueOf(alp), i);
            alp++;
        }
        
        int idx = 0;
        while(idx < msg.length()){
            
            String word = "";
            while(idx < msg.length()){
                if(!dict.containsKey(word + msg.charAt(idx))){
                    // 포함하지 않는다면 새로 저장
                   break;
                }else{
                    word += msg.charAt(idx);
                }
                idx++;
            }
            result.add(dict.get(word));
            
            if(idx < msg.length()){
                dict.put(word + msg.charAt(idx), dict.size()+1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
   
}
