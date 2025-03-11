import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] rc = br.readLine().split(" ");
        int r = Integer.parseInt(rc[0]);
        int c = Integer.parseInt(rc[1]);

        List<Pair> record = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            String cur = br.readLine();
            for (int j = cur.length() - 2; j >= 1; j--) {
                if (cur.charAt(j) != '.') {
                    record.add(new Pair(cur.charAt(j), j));
                    break;
                }
            }
        }

        int[] result = new int[9];
        Map<Integer, List<Pair>> grouped = new HashMap<>();

        for (Pair p : record) {
            grouped.computeIfAbsent(p.second, k -> new ArrayList<>()).add(p);
        }

        List<Map.Entry<Integer, List<Pair>>> sortedEntries = new ArrayList<>(grouped.entrySet());
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().get(0).second, entry1.getValue().get(0).second));

        for (int index = 0; index < sortedEntries.size(); index++) {
            Map.Entry<Integer, List<Pair>> entry = sortedEntries.get(index);
            List<Pair> value = entry.getValue();
            for (Pair p : value) {
                if (value.size() == 1) {
                    result[p.first - '1'] = index + 1;
                } else {
                    result[p.first - '1'] = index + 1;
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            bw.write(result[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static class Pair {
        char first;
        int second;

        Pair(char first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
