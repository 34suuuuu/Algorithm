import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

		for (int i = 0; i < clothes.length; i++) {
			clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0) + 1);
		}
		int answer = 1;
		for (Integer i : clothesMap.values()) {
			answer *= (i + 1);
		}
		answer--;
        return answer;
    }
}