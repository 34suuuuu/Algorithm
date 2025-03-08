import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> scores = new HashMap<>();
		for (int i = 0; i < 8; i++) {
			scores.put(Integer.parseInt(br.readLine()), i);
		}
		List<Integer> keySet = new ArrayList<>(scores.keySet());
		Collections.sort(keySet, Collections.reverseOrder());

		int sum = 0;
		int[] index = new int[5];
		for (int i = 0; i < 5; i++) {
			sum += keySet.get(i);
			index[i] = scores.get(keySet.get(i)) + 1;
		}
		Arrays.sort(index);
		System.out.println(sum);
		for (int i : index) {
			System.out.print(i + " ");
		}

	}
}
