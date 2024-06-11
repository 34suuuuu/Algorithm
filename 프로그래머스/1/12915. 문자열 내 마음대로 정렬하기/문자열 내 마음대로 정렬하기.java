import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Map<String, String> treeMap = new TreeMap<>();

		for (String s : strings) {
			treeMap.put(s.charAt(n) + s, s);
		}
		int idx  = 0;
		for (String s : treeMap.values()) {
			answer[idx] = s;
			idx++;
		}
        return answer;
    }
}