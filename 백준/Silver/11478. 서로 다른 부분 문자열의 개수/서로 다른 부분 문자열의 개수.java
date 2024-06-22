import java.util.TreeSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        Set<String> set = new TreeSet<String>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; j <= str.length(); j++) {
                if (i + j <= str.length()) {
                    set.add(str.substring(i, i + j));
                }
            }
        }
        System.out.println(set.size());
    }
}
