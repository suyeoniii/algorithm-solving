import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 행렬
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] arr1 = new char[n][];
		char[][] arr2 = new char[n][];
		for(int i = 0; i<n; i++){
			arr1[i] = br.readLine().toCharArray();
		}

		for(int i = 0; i<n; i++){
			arr2[i] = br.readLine().toCharArray();
		}

		int result = 0;
		if(n >= 3 && m >= 3){
			for(int i = 0; i<n-2; i++){
				for(int j = 0; j<m-2; j++){
					if(arr1[i][j] != arr2[i][j]){
						result ++;
						// 뒤집기
						for(int k = 0; k<3; k++){
							for(int l = 0; l<3; l++){
								if(arr1[i+k][j+l] == '0') {
									arr1[i+k][j+l] = '1';
								}
								else {
									arr1[i+k][j+l] = '0';
								}
							}
						}
					}
				}
			}
		}

		if(!Arrays.deepEquals(arr1, arr2)){
			result = -1;
		}

		System.out.println(result);
	}

}
