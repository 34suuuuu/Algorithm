import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        // 입퇴실 시간을 분으로 변환해 저장
        int[][] minutes = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++){
            minutes[i][0] = convertToMin(book_time[i][0]);
            minutes[i][1] = convertToMin(book_time[i][1]) + 10;
        }
        
        // 입실 시간으로 정렬
        Arrays.sort(minutes, (x, y) -> x[0] - y[0]);
        
        ArrayList<int[]> rooms = new ArrayList<>();
        rooms.add(minutes[0]);
        
        for(int i = 1; i < minutes.length; i++){
            int in = minutes[i][0];
            
            for(int j = 0; j < rooms.size(); j++){
                if(in >= rooms.get(j)[1]){
                    rooms.remove(j);
                    break;
                }
            }
            rooms.add(minutes[i]);
        }
        
        return rooms.size();
    }
    
    public int convertToMin(String time){
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }
}