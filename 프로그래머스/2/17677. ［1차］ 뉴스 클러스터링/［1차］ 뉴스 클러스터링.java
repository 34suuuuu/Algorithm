import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 대소문자 통일
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> tmp = new ArrayList<>();

        for(int i=0;i< str1.length() -1; i++){
            list1.add(str1.substring(i, i+2));
            tmp.add(str1.substring(i, i+2));
        }
        for(int i=0;i< str2.length() -1; i++){
            list2.add(str2.substring(i, i+2));
        }
        // 교집합
        list1.retainAll(list2);
        // 합집합
        tmp.addAll(list2);
        
            	System.out.println(list1.toString());
            	System.out.println(tmp.toString());
            	System.out.println(list1.size());
            	System.out.println(tmp.size());
        return list1.size() / tmp.size() * 65536;
    }
}