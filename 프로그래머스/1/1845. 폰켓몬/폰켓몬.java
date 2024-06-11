import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int num = nums.length / 2;
		Set<Integer> numSet = new HashSet<>();
		for (int i : nums) {
			numSet.add(i);
		}
		int answer = num > numSet.size() ? numSet.size() : num;        return answer;
    }
}