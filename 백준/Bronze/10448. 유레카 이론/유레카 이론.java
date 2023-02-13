import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 10448: 유레카이론
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 삼각수 구해서 저장 - 약 1000까지
		int[] arr = new int[45];

		arr[0] = 1;
		for(int i = 1; i<45; i++){
			arr[i] = arr[i-1] + i+1;
		}

		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			int answer = 0;
			int n = Integer.parseInt(br.readLine());

			// n이 삼각수 중 3개를 더한 값과 일치하면 1
			for(int i: arr) {
				for(int j: arr) {
					for(int k: arr) {
						if(i + j + k == n) {
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
}
