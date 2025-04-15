package most_common_word;

import java.util.*;

class Solution {
    /**
     * 첫번째 풀이
     * map으로 등장횟수 세고, map을 반복하며 금지되지 않으면서 가장 등장 빈도높은 단어 찾기
     * 시간 복잡도: O(N*B)
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] arr = paragraph.toLowerCase().split("[!?',;.\\s]+"); // O(L) + O(L)
        Map<String, Integer> map = new HashMap<>();

        // 등장 횟수 세기 O(N)
        for(String word: arr){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // banned에 포함되지 않으면서, 가장 큰 값 찾기
        int maxValue = 0;
        String answer = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()) { // O(N) or O(K) key 개수만큼
            if (entry.getValue() > maxValue && !Arrays.asList(banned).contains(entry.getKey())) { // O(B) banned 배열 길이
                    maxValue = entry.getValue();
                    answer = entry.getKey();
                }

        }
        return answer;
    }

    /**
     * 2번째 풀이
     * banned에 포함되지 않는 값 중 등장횟수 세서 가장 많이 등장한 값 찾기
     * 시간 복잡도: O(N*B)
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord2(String paragraph, String[] banned) {
        String[] arr = paragraph.toLowerCase().split("[!?',;\\.\\s]+");
        Map<String, Integer> map = new HashMap<>();

        // banned에 포함되지 않는 값 중, 등장횟수 세기
        for(String word: arr){ // O(N * B)
            if (!Arrays.asList(banned).contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // 가장 큰 값 찾기
        int maxValue = 0;
        String answer = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()) { // O(N)
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                answer = entry.getKey();
            }
        }
        return answer;
    }

    /**
     * 3번째 풀이
     * 1번 풀이에서 Arrays.asList(banned).contains 대신 Set 사용으로 개선
     * 시간 복잡도: O(N)
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord3(String paragraph, String[] banned) {
        String[] arr = paragraph.toLowerCase().split("[!?',;.\\s]+"); // O(L) + O(L)
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        // 등장 횟수 세기 O(N)
        for(String word: arr){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // banned에 포함되지 않으면서, 가장 큰 값 찾기
        int maxValue = 0;
        String answer = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()) { // O(N) or O(K) key 개수만큼
            if (entry.getValue() > maxValue && !bannedSet.contains(entry.getKey())) { // O(1) set 사용해서
                maxValue = entry.getValue();
                answer = entry.getKey();
            }

        }
        return answer;
    }

    /**
     * 4번째 풀이
     * AI가 풀어준 풀이 - 한글자씩 순회하며 단어 만들고 개수 세기
     * 시간 복잡도: O(N)
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord4(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        int maxValue = 0;
        String answer = "";
        StringBuilder word = new StringBuilder();

        // O(N)
        for(int i = 0; i<=paragraph.length(); i++){
            char c = (i<paragraph.length()) ? Character.toLowerCase(paragraph.charAt(i)) : ' ';

            if(Character.isLetter(c)) {
                word.append(c);
            } else if (!word.isEmpty()) {
                String w = word.toString();

                if (!bannedSet.contains(w)) {
                    int count = map.getOrDefault(w, 0) + 1;
                    map.put(w, count);

                    if (count > maxValue) {
                        maxValue = count;
                        answer = w;
                    }
                }
                word.setLength(0);
            }
        }

        return answer;
    }
}
