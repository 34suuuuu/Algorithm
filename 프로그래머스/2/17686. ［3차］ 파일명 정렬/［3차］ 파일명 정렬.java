import java.io.*;
import java.util.*;

class File implements Comparable<File>{
    String head, number;
    int idx;
    
    File(String head, String number, int idx){
        this.head = head;
        this.number = number;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(File o){
        String head1 = this.head.toLowerCase();
        String head2 = o.head.toLowerCase();
        int headCmp = head1.compareTo(head2);
        if(headCmp != 0)return headCmp;
        
        int num1 = Integer.parseInt(this.number);
        int num2 = Integer.parseInt(o.number);
        return Integer.compare(num1, num2);
    }
    
    
}

class Solution {
    public String[] solution(String[] files) {   
        List<File> result = new ArrayList<>();
        
        for(int i = 0; i < files.length; i++){
            String[] file = splitFile(files[i]);
            result.add(new File(file[0], file[1], i));
        }
        Collections.sort(result);
        
        String[] answer = new String[files.length];
        for(int i = 0; i < files.length; i++){
            answer[i] = files[result.get(i).idx];
            
        }
        return answer;
       
    }
    
    public String[] splitFile(String s){
        String[] s1 = s.split("[0-9]+");
        String[] n1 = s.split("[^0-9]+");
        return new String[]{s1[0], n1[1]};
    }
}
    
