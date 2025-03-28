import java.util.*;
class Solution {
    public int[] solution(String s) {
       
        String[] substring = s.substring(2, s.length()-2).split("\\},\\{");     
        
        Arrays.sort(substring, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.length() - o2.length(); 
            }
        });
        
        ArrayList<Integer> tuples = new ArrayList<>();
        for(String str: substring){
            String[] elements = str.split(",");
            
            for(String element : elements){
                int num = Integer.parseInt(element);
                if(tuples.contains(num))continue;
                tuples.add(num);
            }
        }
       
        
        return tuples.stream().mapToInt(Integer::intValue).toArray();
    }
}