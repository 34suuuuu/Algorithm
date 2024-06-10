import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			//	양수를 주면 순서를 바꾸지 않겠다
			//	음수를 주면 순서를 바꾸겠다
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				} else if (Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}else{
					return -1;
				}
			}
		});

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				pq.add(num);
			} else {
				System.out.println(!pq.isEmpty() ? pq.poll() : 0);
			}
		}
	}
}
