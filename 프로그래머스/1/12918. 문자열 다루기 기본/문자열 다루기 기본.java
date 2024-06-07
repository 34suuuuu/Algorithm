import java.util.regex.Pattern;

class Solution {
    public boolean solution(String s) {
        		boolean answer = (Pattern.matches("[0-9]+", s) && (s.length() == 4 || s.length() == 6));

        return answer;
    }
}