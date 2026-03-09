import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> que = new LinkedList<>();
        int sum = 0;
        for(int truck : truck_weights){
            
            while(true){
                if(que.isEmpty()){
                    que.add(truck);
                    sum += truck;
                    answer++;
                    break;
                }
                else if(que.size() == bridge_length){
                    sum -= que.poll();
                }else{
                    if(sum + truck <= weight){
                        que.add(truck);
                        sum += truck;
                        answer++;
                        break;
                    }else{
                        que.add(0);
                        answer++;
                    }
                }
            }   
        }
        return answer += bridge_length;
    }
}