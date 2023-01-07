import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 팰린드롬 만들기
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		Comparator<Character> comparator = Character::compareTo;
		Map<Character, Integer> map = new TreeMap<>(comparator);

		// map에 각 알파벳 개수 세기
		for(char c: s.toCharArray()){
			int count = map.getOrDefault(c, 0);
			map.put(c, count + 1);
		}

		String result = "";
		StringBuilder left = new StringBuilder();
		StringBuilder right = new StringBuilder();
		Character center = 'a';

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			// 알파벳 개수가 홀수면서 다른 알파벳이 홀수가 아닐때 center 업데이트
			if(entry.getValue() % 2 == 1){
				if(center == 'a'){
					center = entry.getKey();
				}
				else {
					result = "I'm Sorry Hansoo";
					break;
				}
			}

			String s2 = Character.toString(entry.getKey()).repeat(entry.getValue() / 2);
			left.append(s2);
			right.insert(0, s2);
		}

		if(result.equals("")){
			if(center != 'a'){
				result = left.toString() + center + right;
			}
			else {
				result = left.toString() + right;
			}
		}

		System.out.println(result);
	}
}
