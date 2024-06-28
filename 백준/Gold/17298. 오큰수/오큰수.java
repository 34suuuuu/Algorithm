import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
				arr[stack.pop()] = arr[i];
			}
			stack.push(i);
		}

		while(!stack.isEmpty()){
			arr[stack.pop()] = -1;
		}
		for (int i : arr) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
