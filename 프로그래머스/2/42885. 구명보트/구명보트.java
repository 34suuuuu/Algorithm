import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        
        Arrays.sort(people);
        
        for(int i : people){
            deque.add(i);
        }
        
		while(!deque.isEmpty()) {
            answer++;
            
            int max = deque.pollLast();
            if(!deque.isEmpty() && deque.peekFirst() + max <= limit){
                deque.pollFirst();
            }
        }
        return answer;
    }
}