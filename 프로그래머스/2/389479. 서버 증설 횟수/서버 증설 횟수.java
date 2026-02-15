import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[24];
        
        for(int i=0; i < 24; i++){
            // 증설된 서버가 필요 서버보다 적은 경우 증설 필요
            // 얼마만큼? players[i] / m - server[i] 만큼
            
            if(players[i] / m > server[i]){
                int cnt = players[i] / m - server[i];
                for(int j=0; j< k; j++){
                   if(i+j < 24){
                       server[i + j] += cnt;            
                       if(j == 0){
                       System.out.println(i+ " " + players[i] + " " + cnt);
                       }      
                   }
                 
               }
               answer+=cnt;
               
           }
        }
        return answer;
    }
   
}