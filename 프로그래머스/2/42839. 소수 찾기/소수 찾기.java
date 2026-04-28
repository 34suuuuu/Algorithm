import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] visited = new boolean[7];
    
    public int solution(String numbers) {
        int answer = 0;
  
        for(int i=0; i<numbers.length(); i++){
            dfs(numbers, "", i+1);
        }
        
        for(Integer num : set){
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
   
    
    private static void dfs(String str, String tmp, int idx){
        if(tmp.length() == idx){
            int num = Integer.parseInt(tmp);
            set.add(num);
        }
        
        for(int i=0; i<str.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                tmp += str.charAt(i);
                dfs(str, tmp, idx);
                visited[i] = false;
                tmp = tmp.substring(0, tmp.length() - 1);
            }
        }
        
    }
    
    // 소수인지 판단
    private static boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0) return false;  
        }
        return true;
        
    }
}