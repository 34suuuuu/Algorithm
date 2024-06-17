import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
		for (int i : numbers) {
			list.add(String.valueOf(i));
		}
		list.sort((o1,o2) -> (o2 + o1).compareTo(o1 + o2));
		
        for (String s : list) {
			answer += s;
		}
        if (answer.charAt(0) == '0') {
			answer = "0";
		}
        return answer;
    }
}