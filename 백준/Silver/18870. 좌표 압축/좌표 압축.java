import java.util.HashMap;
import java.util.Scanner;

import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] sorted = new int[n];
        int[] origin = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sorted[i] = sc.nextInt();
            origin[i] = sorted[i];
        }
        sort(sorted);

        int rank = 0;
        for(int s : sorted)
            if(!map.containsKey(s)){
                map.put(s, rank);
                rank++;
            }

        StringBuilder sb = new StringBuilder();
        for (int k : origin) {
            int ranking = map.get(k);
            sb.append(ranking + " ");
        }
        System.out.println(sb);


    }
}
