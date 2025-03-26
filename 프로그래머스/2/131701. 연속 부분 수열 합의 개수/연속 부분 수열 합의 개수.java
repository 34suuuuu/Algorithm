import java.util.*;

class Solution {
    public int solution(int[] elements) {        
        Set<Integer> set =  new HashSet<>();
        
        int cnt = 1;
        while (cnt <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                
                int sum = 0;
                for (int j = i; j < i + cnt; j++) {
                    sum += elements[j % elements.length];
                }
                set.add(sum);
            }
            cnt++;
        }
        return set.size();
    }
}