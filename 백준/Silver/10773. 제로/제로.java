import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res = 0;

		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		while(k --> 0){
			int num = Integer.parseInt(br.readLine());
			if(num == 0){
				stack.pop();
				continue;
			}
			stack.push(num);
		}

		while(!stack.isEmpty()){
			res += stack.pop();
		}
		System.out.println(res);
	}
}
