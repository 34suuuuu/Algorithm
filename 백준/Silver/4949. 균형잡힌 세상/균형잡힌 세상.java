import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Balance{
	public boolean balance(String arr){
		Stack<Character> s = new Stack<>();

		for(int i=0;i<arr.length();i++){
			char c = arr.charAt(i);
			if(c=='[' || c=='('){
				s.push(c);
			}else if(c==']'){
				if(s.isEmpty() || s.pop() !='['){
					return false;
				}
			}else if(c==')'){
				if(s.isEmpty() || s.pop() !='('){
					return false;
				}
			}
		}
		return s.isEmpty();
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Balance b = new Balance();

		while (true) {
			String arr = br.readLine();
			if(arr.equals(".")) break;
			if(b.balance(arr)) {
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
		}
	}
}
