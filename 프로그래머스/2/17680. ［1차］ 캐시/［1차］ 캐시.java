import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> LRU= new LinkedList<>();
        
        for(String s : cities){ 
            s = s.toUpperCase();
            
            if(LRU.isEmpty()){
               answer+=5;
            }else{
                // 포함하고 있는 경우 hit
                if(LRU.contains(s)){
                    answer++;
                    if(LRU.size() == cacheSize){
                        LRU.remove(s);
                    }
                }else{
                    // 없으면 miss
                    answer+=5;
                    if(LRU.size() == cacheSize){
                        LRU.poll();
                    }
                }
            }
            if(cacheSize > 0){
                LRU.add(s);
            }
            
        }
        return answer;
    }
}