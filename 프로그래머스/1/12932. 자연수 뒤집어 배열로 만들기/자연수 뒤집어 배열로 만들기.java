class Solution {
    public int[] solution(long n) {
        String[] strings = String.valueOf(n).split("");
        int[] answer = new int[strings.length];
        int idx = 0;
        for(int i=strings.length-1; i>=strings.length/2; i--){
            answer[idx] = Integer.parseInt(strings[i]);
            answer[i] = Integer.parseInt(strings[idx]);
            idx++;
        }
        return answer;
    }
}