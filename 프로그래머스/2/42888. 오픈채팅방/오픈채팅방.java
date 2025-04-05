import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> names = new HashMap<>();
        for(String input : record){
            String[] cmd = input.split(" ");
            if(cmd[0].equals("Change")){
                // 기존의 이름 변경
                   names.replace(cmd[1], cmd[2]);
            }else if(cmd[0].equals("Enter")){
                // 없으면 추가
                names.put(cmd[1], cmd[2]);
            }
        }
        
        List<String> list = new ArrayList<>();
        for(String input : record){
            String[] cmd = input.split(" ");
            if(cmd[0].equals("Enter")){
                list.add(names.get(cmd[1])+"님이 들어왔습니다.");
            }else if(cmd[0].equals("Leave")){
                list.add(names.get(cmd[1])+"님이 나갔습니다.");
            }
        }
        
        return list.stream().toArray(String[]::new);
    }
}