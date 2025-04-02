import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ValidAnagram {
    /**
     * 정렬로 구현
     * 실행시간 - 3ms
     * 시간복잡도 - (O(n log n))
     */
    public boolean isAnagram(String s, String t) {
        // 길이가 다르면 애너그램이 아니므로 return
        if (s.length() != t.length()) return false;

        // 배열로 변환
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        // 정렬
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    /**
     * Map 사용해서 구현
     * 실행시간 - 12ms
     * 시간복잡도 - (O(n))
     */
    public boolean isAnagram2(String s, String t) {
        // 길이가 다르면 애너그램이 아니므로 return
        if (s.length() != t.length()) return false;

        Map<Character, Integer> m = new HashMap<>();

        // s 문자 개수 증가
        for (char c : s.toCharArray()) {
            m.merge(c, 1, Integer::sum);
        }

        // t 문자 개수 감소
        for (char c : t.toCharArray()) {
            m.merge(c, -1, Integer::sum);
        }

        // 모든 값이 0인지 확인
        return m.values().stream().allMatch(v -> v == 0);
    }

    /**
     * 배열
     * (O(n))
     * 공간 - 26짜리 배열 2개
     */
    public boolean isAnagram3(String s, String t) {
        // 길이가 다르면 애너그램이 아니므로 return
        if (s.length() != t.length()) return false;

        int[] sArr = new int[26];  // 알파벳은 26개
        int[] tArr = new int[26];

        // s 문자 개수 세기
        for (char c : s.toCharArray()) {
            sArr[c - 'a']++;  // 'a'의 ASCII 값(97)을 빼서 0-25 인덱스로 변환
        }

        // t 문자 개수 세기
        for (char c : t.toCharArray()) {
            tArr[c - 'a']++;
        }

        // 배열 값 같은지 비교
        return Arrays.equals(sArr, tArr);
    }
}
