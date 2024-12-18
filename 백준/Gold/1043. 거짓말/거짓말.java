import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] know;
    static boolean[][] meet;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        know = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            know[Integer.parseInt(st.nextToken())] = true;
        }

        int[][] party = new int[M][];
        meet = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
 
            party[i] = new int[size];
            party[i][0] = Integer.parseInt(st.nextToken());

            for (int j = 1; j < size; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
                meet[party[i][j - 1]][party[i][j]] = meet[party[i][j]][party[i][j - 1]] = true;
            }

        }
        for (int i = 1; i <= N; i++) {
            if(know[i]) dfs(i);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (!know[party[i][0]]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int n) {
        for (int i = 1; i <= N; i++) {
            if (meet[n][i] && !know[i]) {
                know[i] = true;
                dfs(i);
            }
        }
    }
}