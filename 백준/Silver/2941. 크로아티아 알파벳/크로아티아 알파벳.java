import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] alphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

		String str = sc.nextLine();

		for (int i = 0; i < alphabets.length; i++) {
			if(str.contains(alphabets[i])){
				str = str.replace(alphabets[i], "/");
			}
		}
		System.out.println(str.length());
	}
}
