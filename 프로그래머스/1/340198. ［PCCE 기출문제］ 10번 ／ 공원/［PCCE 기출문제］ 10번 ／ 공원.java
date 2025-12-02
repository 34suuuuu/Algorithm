import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int res = -1;
        
        // 1. mats 내림차순 정렬
        Arrays.sort(mats);
        for(int i=0; i<mats.length/2; i++){
            int tmp = mats[i];
            mats[i] = mats[mats.length - 1 - i];
            mats[mats.length - 1 - i] = tmp;
        }
    
        // 2.돗자리 놓을 수 있는 가장 큰 영역 확인
        for(int mat: mats){
            for(int i = 0; i <= park.length - mat; i++){
                for(int j = 0; j <= park[0].length - mat; j++){
                   boolean chk = true;
                    
                   if(park[i][j].equals("-1")){
                       // 내부 영역 확인
                       for(int n = 0; n < mat; n++){
                           for(int m = 0; m < mat; m++){
                               if(!park[i+n][j+m] .equals("-1")){
                                   // 내부 영역에서 -1이 아니면 돗자리 놓을 수 없음
                                   chk = false;
                                   break;
                               }
                           }
                           if(!chk) break;
                       }
                       if(chk) return mat;
                   }
                }
            }
        }
        return res;
    }    
}