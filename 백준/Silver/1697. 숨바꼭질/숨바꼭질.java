import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] check = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    public static void bfs(int num) {
        check[num] = 1;
        queue.add(num);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int next;

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = cur - 1;
                } else if (i == 1) {
                    next = cur + 1;
                } else {
                    next = cur * 2;
                }

                if (next == K) {
                    System.out.println(check[cur]);
                    return;
                }
                if (next >= 0 && next < check.length && check[next] == 0) {
                    queue.add(next);
                    check[next] = check[cur] + 1;
                }
            }
        }
    }
}
