import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()){
			arr.add(Integer.parseInt(st.nextToken()));
		}

		arr.sort(Integer::compareTo);

		int result = arr.get(0);
		arr.set(0, arr.get(0));
		for(int i = 1; i<n; i++){
			arr.set(i, (arr.get(i) + arr.get(i-1)));
			result += arr.get(i);
		}

		System.out.println(result);
	}
}
