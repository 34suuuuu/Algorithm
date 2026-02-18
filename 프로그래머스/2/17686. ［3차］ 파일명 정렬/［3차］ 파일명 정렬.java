import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] files) {                
        Arrays.sort(files, (a, b) -> {
            String[] s1 = splitFile(a);
            String[] s2 = splitFile(b);
            
            // 1. 대소문자 구분없이 head 오름차순
            String head1 = s1[0].toLowerCase();
            String head2 = s2[0].toLowerCase();
            int headCmp = head1.compareTo(head2);
            
            if(headCmp != 0){
                return headCmp;
            }
            
            // 2. number 오름차순
            int num1 = Integer.parseInt(s1[1]);
            int num2 = Integer.parseInt(s2[1]);
            return Integer.compare(num1, num2); 
        });
        return files;
    }
    
    public String[] splitFile(String s){
        String[] s1 = s.split("[0-9]+");
        String[] n1 = s.split("[^0-9]+");
        return new String[]{s1[0], n1[1]};
    }
}
    
