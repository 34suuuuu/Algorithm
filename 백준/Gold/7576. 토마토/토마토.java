import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato{
	int x;
	int y;
	int day;

	Tomato(int x, int y, int day){
		this.x = x;
		this.y = y;
		this.day = day;
	}
}

public class Main {
	static int m,n;
	static int[][] tomatos;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static Queue<Tomato> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		tomatos = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				// 1: 익은 토마토
				// 0: 익지않은 토마토
				// -1: 토마토가 들어있지않은 칸
				tomatos[i][j] = Integer.parseInt(st.nextToken());
				if (tomatos[i][j] == 1) {
					// 익은 토마토의 위치 큐에 저장
					que.add(new Tomato(i, j, 0));
				}
			}
		}

		bfs();

	}

	public static void bfs() {
		int day = 0;

		while(!que.isEmpty()) {
			Tomato cur = que.poll();
			day = cur.day;

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if(nx < 0 || nx >= n || ny < 0 || ny>= m) continue;

				if (tomatos[nx][ny] == 0) {
					tomatos[nx][ny] = 1;	// 익지 않은 토마토라면 익은 상태로 변경
					que.add(new Tomato(nx, ny, day + 1));	// 익은 상태니깐 큐에 삽입
				}
			}
		}

		if (chkTomato()) {
			System.out.println(day);
		} else {
			System.out.println(-1);
		}
	}

	public static boolean chkTomato(){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(tomatos[i][j] == 0) return false;
			}
		}
		return true;
	}
}
