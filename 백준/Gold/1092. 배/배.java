import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> cranes;
	static List<Integer> boxes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		cranes = new ArrayList<>();
		boxes = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cranes.add(Integer.parseInt(st.nextToken()));
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			boxes.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(cranes, Collections.reverseOrder());
		Collections.sort(boxes, Collections.reverseOrder());

		if (cranes.get(0) < boxes.get(0)) {
			System.out.println(-1);
			return;
		}

		int time = 0;
		while (!boxes.isEmpty()) {
			int idx = 0;
			for (int i = 0; i < cranes.size(); i++) {
				if(idx == boxes.size()) break;
				else if (cranes.get(i) >= boxes.get(idx)) {
					boxes.remove(idx);
				} else {
					idx++;
					i--;
				}
			}
			time++;
		}
		System.out.println(time);
	}
}
