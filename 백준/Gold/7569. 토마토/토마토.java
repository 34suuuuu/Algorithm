import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int x,y,z;
	Tomato(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int[][][] tomatos;
	static int sizeX ,sizeY, sizeZ;
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dy = { 1, -1, 0, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static Queue<Tomato> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		sizeY = Integer.parseInt(st.nextToken());
		sizeX = Integer.parseInt(st.nextToken());
		sizeZ = Integer.parseInt(st.nextToken());
		tomatos = new int[sizeX][sizeY][sizeZ];

		for (int i = 0; i < sizeZ; i++) {
			for (int j = 0; j < sizeX; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < sizeY; k++) {
					tomatos[j][k][i] = Integer.parseInt(st.nextToken());
					if(tomatos[j][k][i] == 1){
						queue.add(new Tomato(j, k, i));
					}
				}
			}
		}
		bfs();
		checkTomato();

	}

	static void bfs(){
		while(!queue.isEmpty()){
			Tomato tomato = queue.poll();
			int curX = tomato.x;
			int curY = tomato.y;
			int curZ = tomato.z;

			for (int i = 0; i < 6; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				int nz = curZ + dz[i];

				if(nx < 0 || ny < 0 || nz< 0 || nx >= sizeX || ny >= sizeY || nz >= sizeZ) continue;
				if(tomatos[nx][ny][nz] == 0) { // 익지 않은 상태
					queue.add(new Tomato(nx, ny, nz));
					tomatos[nx][ny][nz] = tomatos[curX][curY][curZ] + 1;
				}
			}
		}
	}

	static void checkTomato(){
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < sizeZ; i++) {
			for (int j = 0; j < sizeX; j++) {
				for (int k = 0; k < sizeY; k++) {
					if(tomatos[j][k][i] == 0){
						System.out.println(-1);
						return;
					}
					result = Math.max(result, tomatos[j][k][i]);
				}
			}
		}
		if (result == 1) {
			System.out.println(0);
		} else {
			System.out.println(result - 1);
		}
	}
}
