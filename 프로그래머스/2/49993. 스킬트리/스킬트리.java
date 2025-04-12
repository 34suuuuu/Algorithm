import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        List<List<Integer>> index = new ArrayList<>();
        for(String str: skill_trees){
            String[] strList = str.split("");
            
            List<Integer> tmp = new ArrayList<>();
            for(int i=0; i<str.length(); i++){
                if(skill.indexOf(strList[i]) >= 0) tmp.add(skill.indexOf(strList[i]));
            } 
            index.add(tmp);
        }
      
        for(List<Integer> list : index){
            System.out.println(list);
            if(list.size() <= 0) answer++;
            else if(isSorted(list)) answer++;
        }
        
        return answer;
    }
    
    public static boolean isSorted(List<Integer> list){
        if(list.get(0) != 0) return false;
        
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) > list.get(i+1) || list.get(i+1) - list.get(i) > 1) {
                return false;
            }
                        
        }
        return true;
    }
    
  
}