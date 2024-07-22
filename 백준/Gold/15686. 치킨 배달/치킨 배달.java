import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, min = Integer.MAX_VALUE;
    static int[][] maps;
    static ArrayList<Node> houses = new ArrayList<>();
    static ArrayList<Node> chicken = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 1) {
                    houses.add(new Node(i, j));
                } else if (maps[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];
        backtraking(0, 0);
        System.out.println(min);
    }

    public static void backtraking(int depth, int start) {
        if (depth == M) {
            int total = 0;
            for (int i = 0; i < houses.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j] == true) {
                        int dist = Math.min(min, Math.abs(houses.get(i).x - chicken.get(j).x) + Math.abs(houses.get(i).y - chicken.get(j).y));
                        tmp = Math.min(tmp, dist);
                    }
                }
                total += tmp;
            }
            min = Math.min(total, min);
        }

        for (int i = start; i < chicken.size(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                backtraking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}