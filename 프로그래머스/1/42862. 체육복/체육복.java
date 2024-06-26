import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
     
		Set<Integer> lostSet = new HashSet<>();
		Arrays.sort(reserve);

		for (int l : lost) {
			lostSet.add(l);
		}

		for (int i = 0; i < reserve.length; i++) {
			if(lostSet.contains(reserve[i])){
				lostSet.remove(reserve[i]);
				reserve[i] = -1;
			}
		}

		for (int i = 0; i < reserve.length; i++) {
			if (reserve[i] == -1) continue;
			if (lostSet.contains(reserve[i] - 1)) {
				lostSet.remove(reserve[i] - 1);
			}else if (lostSet.contains(reserve[i] + 1)) {
				lostSet.remove(reserve[i] + 1);
			}
		}
		return n-lostSet.size();
    }
}