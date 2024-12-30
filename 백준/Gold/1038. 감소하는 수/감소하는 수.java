import java.util.*;
import java.io.*;

public class Main {
	static List<Long> list = new ArrayList<>();
	static int n;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		if(n <= 10) {
			System.out.print(n);
			return;
		} else if (n >= 1023) {
			System.out.print(-1);
			return;
		}

		for(int i = 0; i < 10; i++) {
			dfs(i);
		}

		Collections.sort(list);
		System.out.print(list.get(n));
	} 

	private static void dfs(long num) {		
		list.add(num);		
		long modValue = num % 10;
        
		if(modValue == 0) {
			return;
		}
		
		for(long i = modValue - 1; i >= 0; i--) {
			long newValue = num * 10 + i;
			dfs(newValue);
		}
	} 
}