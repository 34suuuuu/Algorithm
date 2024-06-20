import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;
            
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        int[] have = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            have[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(have);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(binarySearch(have, num) < 0) bw.write("0 ");
            else bw.write("1 ");
        }
        bw.close();
        br.close();
    }

    public static int binarySearch(int[] array, int target){

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid= (end+start)/2;
        }
        return -1;
    }
}
