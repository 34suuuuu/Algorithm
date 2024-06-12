import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		char[] strToArray = sc.nextLine().toCharArray();
		Arrays.sort(strToArray);
		StringBuilder sb = new StringBuilder(new StringBuilder(String.valueOf(strToArray)));
		String result = "";
		result = sb.reverse().toString();
		System.out.println(result);

	}
}
