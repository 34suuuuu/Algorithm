import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
	String name;
	double height;

	Student(String name, double height) {
		this.name = name;
		this.height = height;
	}

	@Override
	public int compareTo(Student o) {
		return Double.compare(o.height,this.height);
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		ArrayList<Student>students;

		while (true) {
			int N = Integer.parseInt(br.readLine());

			if(N==0){
				System.out.println(sb);
				return;
			}
			students = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				students.add(new Student(st.nextToken(), Double.parseDouble(st.nextToken())));
			}
			Collections.sort(students);
			// 출력값이 최대값임을 확인하기 위한 더미데이터
			students.add(new Student("max", Integer.MAX_VALUE));

			for(int i=0; i<students.size(); i++){
				sb.append(students.get(i).name + " ");

				if(students.get(i).height != students.get(i+1).height){
					break;
				}
			}
			sb.append("\n");
		}
	}
}
