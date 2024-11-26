import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	static class Time implements Comparable<Time> {
		int start;
		int end;

		public Time(int start, int end){
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			if(this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Time> times = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			times.add(new Time(start, end));
		}
		Collections.sort(times);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(times.get(0).end);

		for (int i = 1; i < n; i++) {
			if(pq.peek() <= times.get(i).start){
				pq.poll();
			}
			pq.offer(times.get(i).end);
		}

		System.out.println(pq.size());
	}
}
