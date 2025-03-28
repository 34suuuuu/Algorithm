import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache= new LinkedList<>();
        
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        for(String city : cities){ 
            city = city.toUpperCase();
            
            if(cache.contains(city)){
                cache.remove(city);
                cache.add(city);
                answer++;
            }else{
                if(cache.size() == cacheSize){
                    cache.remove(0);
                }
                cache.add(city);
                answer+=5;
            }
        }
        return answer;
    }
}