import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[L];
		for(int i = 0; i < L; i++){
			nums[i] = Integer.parseInt(st.nextToken());

		}
		Arrays.sort(nums);

		int n = Integer.parseInt(br.readLine());
		int start = 0, end = 1001;

		for(int num : nums){
			if (num < n) {
				if(num > start) start = num;
			}else if(num > n){
				if(num < end) end = num;
			}else{
				System.out.println(0);
				return;
			}
		}

		int cnt = 0;
		for(int i = start + 1; i <= n; i++){
			for(int j = n; j <= end-1; j++){
				if(i != j) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
