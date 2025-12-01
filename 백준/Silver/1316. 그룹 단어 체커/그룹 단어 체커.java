import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int res = n;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			boolean[] group = new boolean[26];

			for(int j=0; j<str.length()-1; j++) {
				if(str.charAt(j) != str.charAt(j+1)){
					if(group[str.charAt(j+1)-'a']){
						res--;
						break;
					}
				};
				group[str.charAt(j)-'a'] = true;
			}

		}

		System.out.println(res);
	}
}
