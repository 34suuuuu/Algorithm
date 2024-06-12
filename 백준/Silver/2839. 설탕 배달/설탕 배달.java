import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(getCnt(n));

    }

    static int getCnt(int n){
        if(n%5 == 0) {
            return n/5;
        } else{
          int cnt = 0;
          while(n>0){
              n-=3;
              cnt += 1;
              if(n%5 == 0){
                  cnt += (n/5);
                  return cnt;
              }else if(n==1 || n==2){
                  return -1;
              }else if(n==0){
                  return cnt;
              }
          }
        }
        return 0;
    }
}
