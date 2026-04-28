import java.util.*;

class Solution {
    static String alphabet = "AEIOU";
    static List<String> dict = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        
        for(int i=1; i<=5; i++){
            makeWord(i, 0, "");
        }
        
        Collections.sort(dict);
        int idx = 1;
        for(String w : dict){
            if(word.equals(w)){
                answer = idx;
                return answer;
            }
            idx++;
        }

        return answer;
    }
  
    public void makeWord(int num, int cnt, String cmd) {
        if(num == cnt) {
            dict.add(cmd);
            return;
        }
        
        for(int i = 0; i < 5; i++){
            makeWord(num, cnt + 1, cmd + Character.toString(alphabet.charAt(i)));
        }
    }
   
}