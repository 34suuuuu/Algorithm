import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int start = 1;
        int end = house[N - 1] - house[0];
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int left = house[0];
            int cnt = 1;

            for (int i = 1; i < N; i++) {
                if (house[i] - left >= mid) {
                    cnt++;
                    left = house[i];
                }
            }

            if (cnt >= C) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }

}
