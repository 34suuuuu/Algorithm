import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Bus implements Comparable<Bus> {
	int end;
	int cost;

	Bus(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Bus o) {
		return this.cost- o.cost;
	}
}

public class Main {
	static final int INF = 10000001;
	static List<Bus>[] buses;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		buses = new ArrayList[n + 1];
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			buses[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost =  Integer.parseInt(st.nextToken());
			buses[start].add(new Bus(end, cost));
		}

		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		dijkstra(from);
		System.out.println(dist[to]);
	}

	public static void dijkstra(int start) {
		dist[start] = 0;
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		pq.add(new Bus(start, 0));

		while(!pq.isEmpty()) {
			Bus cur = pq.poll();
			if(visited[cur.end]) continue;
			visited[cur.end] = true;

			for (Bus bus : buses[cur.end]) {
				if(!visited[bus.end] && dist[bus.end] > dist[cur.end] + bus.cost) {
					dist[bus.end] = dist[cur.end] + bus.cost;
					pq.add(new Bus(bus.end, dist[bus.end]));
				}
			}
		}
	}
}
