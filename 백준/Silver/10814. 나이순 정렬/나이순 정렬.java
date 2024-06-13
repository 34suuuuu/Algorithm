import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		People[] people = new People[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			people[i] = new People(age, name);
		}

		Arrays.sort(people, (o1,o2) -> {
			return o1.age - o2.age;
		});

		StringBuilder sb = new StringBuilder();
		for (People p : people) {
			sb.append(p.age + " " + p.name).append("\n");
		}
		System.out.println(sb);
	}
}

class People {
	int age;
	String name;

	People(int age, String name) {
		this.age = age;
		this.name = name;
	}
}