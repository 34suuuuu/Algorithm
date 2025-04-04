import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {                    
        Map<String, Integer> feeMap = new HashMap<>();  // (차량 번호, 주차 시간) 저장
        Map<String, Integer> map = new HashMap<>(); // (차량 번호, 입차 시간) 저장

        for(int i = 0; i < records.length; i++){
            String[] record = records[i].split(" ");
            
            String[] time = record[0].split(":");
            String car = record[1];
            String cmd = record[2];
            
            if(cmd.equals("IN")){
                map.put(car, Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
            }else{
                int inTime = map.get(car);  // 입차 시간
                int outTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                map.remove(car); 
                
                if(feeMap.containsKey(car)){
                    feeMap.replace(car, feeMap.get(car) + outTime- inTime);
                }else{
                    feeMap.put(car, outTime - inTime);
                }
            }
        }
        
        // 입차 기록만 있고 출차 기록이 없는 경우
        if(!map.isEmpty()){
            for(String carNum : map.keySet()){
                feeMap.put(carNum, feeMap.getOrDefault(carNum, 0) + 23 * 60 + 59 - map.get(carNum));
            }
        }        
        
        // 차 번호 오름차순으로 정렬
        Object[] sortKey = feeMap.keySet().toArray();
		Arrays.sort(sortKey);
        
        int[] answer = new int[sortKey.length];
    
        // fees[0] : 기본 시간
        // fees[1] : 기본 요금
        // fees[2] : 단위 시간
        // fees[3] : 단위 요금
        for(int i = 0; i < answer.length; i++){
            int time = feeMap.get(sortKey[i]); // 주차 시간
            answer[i] = time > fees[0] ? fees[1] + (int)Math.ceil((time  - fees[0])/ Double.valueOf(fees[2])) * fees[3] : fees[1];
        }
        
        return answer;
    }   
}