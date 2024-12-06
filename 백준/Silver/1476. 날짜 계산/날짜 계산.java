
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int e = Integer.parseInt(strs[0]);
        int s = Integer.parseInt(strs[1]);
        int m = Integer.parseInt(strs[2]);

        int x=0; // e
        int y=0; // s
        int z=0; // m

        int count=1;
        while(true){
            x+=1;
            y+=1;
            z+=1;
            if(x==16) x=1;
            if(y==29) y=1;
            if(z==20) z=1;

            if(x==e && y==s && z==m){
                System.out.println(count);
                break;
            }
            count++;
        }
    }
}
