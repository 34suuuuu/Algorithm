import java.io.*;
import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int cur = changeTime(pos);
        int end = changeTime(video_len);
        
        if(cur >= changeTime(op_start) && cur <= changeTime(op_end)){
            cur = changeTime(op_end);
        }
        
        for(String command: commands){
            if(command.equals("prev")){
                cur = (cur < 10 ? 0 : cur-10);
            }else if(command.equals("next")){
                cur = (cur+10 > end ? end : cur+10);
            }
            if(cur >= changeTime(op_start) && cur <= changeTime(op_end)){
            cur = changeTime(op_end);
            }
        }
        answer+= String.format("%02d", cur/60);
        answer += ":";
        answer += String.format("%02d", cur%60);
    
        return answer;
    }
                     
    public int changeTime(String time){
        String min_str = time.substring(0,2);
        String second_str = time.substring(3,5);
        return Integer.parseInt(min_str)*60 + Integer.parseInt(second_str);
    }
    
 
}

