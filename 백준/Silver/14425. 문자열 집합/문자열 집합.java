import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<String> stArr = new LinkedList<>();
		while (n-- > 0) {
			stArr.add(br.readLine());

		}
		int result = 0;
		while (m-- >0) {
			if(stArr.contains(br.readLine())) result++;
		}
		System.out.println(result);
	}
}
