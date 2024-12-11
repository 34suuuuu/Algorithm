import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int end;
	int cost;

	Node(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node node) {
		return this.cost - node.cost;
	}
}

public class Main {
	static final int INF = 10000001;
	static int v, e, k;
	static int[] dist;
	static List<Node> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());

		dist = new int[v];
		list = new ArrayList[v];

		for (int i = 0; i < v; i++) {
			list[i] = new ArrayList<Node>();
			dist[i] = INF;
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());

			list[start].add(new Node(end, cost));
		}

		dijkstra(k - 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < v; i++) {
			sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
		}
		System.out.println(sb);

	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			for(int i=0; i<list[cur.end].size(); i++) {
				Node next = list[cur.end].get(i);

				if (dist[next.end] > cur.cost + next.cost) {
					dist[next.end] = cur.cost + next.cost;
					pq.add(new Node(next.end, dist[next.end]));
				}
			}
		}
	}
}
