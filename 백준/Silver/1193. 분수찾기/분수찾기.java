import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		String answer = "";

		int x = 1;
		int y = 1;
		int sum = x + y;
		while(X --> 1){
			if(sum % 2 == 0){
				if(x == 1){
					sum++;
					y++;
				}else{
					x--;
					y++;
				}
			}else{
				if(y == 1){
					sum++;
					x++;
				}else{
					x++;
					y--;
				}
			}

		}
		answer = x + "/"  + y;
		System.out.println(answer);


	}
}
