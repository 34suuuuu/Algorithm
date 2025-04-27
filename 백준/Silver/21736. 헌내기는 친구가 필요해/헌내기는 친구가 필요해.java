import java.util.*;
import java.io.*;

public class Main {
    public static char map[][];
    public static boolean visited[][];
    public static int dx[] = {0, 0, 1, -1};
    public static int dy[] = {1, -1, 0, 0};
    public static int n, m, cnt;
    public static int cx, cy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                if(s.charAt(j)=='I'){
                    cx=i;
                    cy=j;
                }
                map[i][j] = s.charAt(j);
            }
        }

        dfs(cx,cy);
        check();
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        if(map[x][y]=='P') cnt++;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < n && cy < m ) {
                if (!visited[cx][cy] && map[cx][cy] != 'X') {
                    dfs(cx, cy);
                }
            }
        }
    }

    public static void check() {
        if (cnt <= 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }
}