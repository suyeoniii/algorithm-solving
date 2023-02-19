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

		int l = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");
		int[] values = Arrays.stream(line)
			.mapToInt(Integer::parseInt)
			.toArray();
		int n= Integer.parseInt(br.readLine());

		Arrays.sort(values);
		int answer = 0;
		// 구간 찾기
		for(int i = 0; i<values.length; i++){
			if(values[i] > n){
				int value = 1;
				
				// n이 집합내 최소숫자보다 작은경우
				if(i != 0){
					value = values[i-1] + 1;
				}
				// 구간 중 n이 포함되는 구간 찾기
				for(int j = value; j<values[i]; j++) {
					for(int k = j+1; k<values[i]; k++) {
						if(k >= n && j <= n) {
							answer++;
						}
					}
				}
				break;
			}
		}
		System.out.println(answer);
	}
}
