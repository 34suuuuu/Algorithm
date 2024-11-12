import java.util.Scanner;

public class Main {

    static int[][] cabbage;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int m, n, k, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int test_case = 1; test_case <= t; test_case++) {
             m = sc.nextInt();
             n = sc.nextInt();
             k = sc.nextInt();

            cabbage = new int[m][n];
            visited = new boolean[m][n];
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                cabbage[x][y] = 1;
            }

            cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (cabbage[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n ) {
                if (!visited[nx][ny] && cabbage[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}