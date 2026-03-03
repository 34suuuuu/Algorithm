import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            
            // 가능한지 확인
            boolean isPossible = true;
            for (int j = 0; j < want.length; j++) {
                int cnt = map.getOrDefault(want[j], 0);
                if (cnt < number[j]) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) answer++;
            
            
            if (i == discount.length - 10) break;

            // 빠지는 품목
            String out = discount[i];
            int outCnt = map.get(out) - 1;
            if (outCnt == 0) map.remove(out);
            else map.put(out, outCnt);

            // 들어오는 품목
            String in = discount[i + 10];
            map.put(in, map.getOrDefault(in, 0) + 1);
        }
        
        return answer;
    }
    
}