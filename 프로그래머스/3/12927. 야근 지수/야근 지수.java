import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i : works) {
			pq.add(i);
		}

		while (n-- > 0) {
			int num = pq.poll();
			num = num >= 1 ? num - 1 : 0;
			pq.add(num);
		}

		for (int i : pq) {
			answer += Math.pow(i, 2);
		}
        return answer;
    }
}