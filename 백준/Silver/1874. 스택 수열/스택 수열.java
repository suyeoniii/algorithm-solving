import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/**
 * 스택 수열
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		ArrayList<Integer> arr = new ArrayList<>();
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			arr.add(n);
		}

		ArrayList<Integer> stack = new ArrayList<>();
		ArrayList<Integer> sortedArr = (ArrayList<Integer>)arr.clone();
		sortedArr.sort(Comparator.comparingInt(i -> i));

		ArrayList<String> result = new ArrayList<>();
		while(sortedArr.size() > 0 || stack.size() > 0){
			// stack의 마지막요소와 남은수열의 첫번째 요소가 같은 경우
			if(stack.size() > 0 && Objects.equals(stack.get(stack.size() - 1), arr.get(0))){
				stack.remove(stack.size()-1);
				arr.remove(0);
				result.add("-");
			} else if (sortedArr.size() > 0) {
				stack.add(sortedArr.get(0));
				sortedArr.remove(0);
				result.add("+");
			} else {
				System.out.println("NO");
				return;
			}
		}

		for(String s: result){
			System.out.println(s);
		}
	}
}
