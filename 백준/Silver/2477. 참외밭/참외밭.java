import java.io.*;
import java.util.*;

public class Main {
	static class Area{
		int direction;
		int distance;

		Area(int direction, int distance) {
			this.direction = direction;
			this.distance = distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		List<Area> areas = new ArrayList<>();
		StringTokenizer st;
		int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE, sum = 0;

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			areas.add(new Area(dir, distance));

			// 가로, 세로 최대값으로 전체 면적 구하기
			if (areas.get(i).direction == 1 || areas.get(i).direction == 2) {
				x = Math.max(areas.get(i).distance, x); // 가로
			} else {
				y = Math.max(areas.get(i).distance, y); // 세로
			}
		}
		// 아래에서 비교를 위해 get(0)을 한번 더 추가
		areas.add(areas.get(0));
		sum += (x * y);

		for(int i = 0; i < areas.size() - 1; i++) {
			Area pre = areas.get(i);
			Area next = areas.get(i + 1);

			if((pre.direction== 1 && next.direction == 3) || (pre.direction == 2 && next.direction == 4) ||
				(pre.direction == 3 && next.direction == 2) || (pre.direction == 4 && next.direction == 1)) {
				sum -= (pre.distance * next.distance);
				break;
			}
		}
		System.out.println(sum * K);
	}
}
