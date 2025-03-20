class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        for(int i=1 ;i<total; i++){
            if(total % i == 0){
                int row = i;
                int col = total/row;
                
                if(row > col) continue;
                
                int in = (row-2) * (col-2);
                if(in == yellow){
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }
}