import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14697: 방 배정하기
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int answer = 0;

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		for(int i = 0; i<=n/a; i++){
			for(int j = 0; j<=n/b; j++){
				for(int k = 0; k<=n/c; k++){
					if(i*a + j*b + k*c == n) {
						answer = 1;
						break;
					}
				}
				if(answer == 1) {
					break;
				}
			}
			if(answer == 1) {
				break;
			}
		}

		System.out.println(answer);
	}
}
