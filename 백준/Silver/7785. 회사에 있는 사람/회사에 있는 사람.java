import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < N; i++) 
		{
			String name = sc.next();
			String log = sc.next();
			if (map.containsKey(name)) map.remove(name);
			else map.put(name, log);
		}
		ArrayList<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list, Collections.reverseOrder());
		for(int i = 0; i < list.size(); ++i) System.out.println(list.get(i));
	}
}