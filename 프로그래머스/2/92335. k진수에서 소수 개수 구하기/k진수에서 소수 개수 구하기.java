import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String result = Integer.toString(n,k); // k진수로 변환
        String[] arr = result.split("0");
        
        for(String s : arr){
            if(!s.isEmpty()){
                long num = Long.parseLong(s);
                if(isPrime(num)) answer++;
            }
        }
  
        return answer;
    }

    //소수인지 판단
    public boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}