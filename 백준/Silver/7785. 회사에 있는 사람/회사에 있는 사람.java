import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		HashSet<String> attendance = new HashSet<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String attend = st.nextToken();

			if (attend.equals("enter")) {
				attendance.add(name);
			} else {
				attendance.remove(name);
			}
		}

		ArrayList<String> names = new ArrayList<String>(attendance);
		Collections.sort(names, Collections.reverseOrder()); //내림차순으로 정렬
		for (String name : names) {
			System.out.println(name);
		}
	}
}
