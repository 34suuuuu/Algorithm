class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        int idx = 0;
        dfs(0, idx, numbers, target);
        
        return answer;
    }
    
    static void dfs(int num, int idx, int[] numbers, int target) {
		if (idx == numbers.length) {
			if(num == target){
				answer++;
				return;
			}
		} else {
			dfs(num - numbers[idx], idx + 1, numbers, target);
			dfs(num + numbers[idx], idx + 1, numbers, target);
		}
	}
}