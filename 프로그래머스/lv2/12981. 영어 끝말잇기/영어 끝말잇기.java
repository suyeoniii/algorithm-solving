import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        
        for(int i = 1; i<words.length; i++){
            // 말했던 단어를 말한 경우 || 끝말이 안이어지는 단어를 말한 경우
            if(set.contains(words[i])
               || (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0))){
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            set.add(words[i]);
        }

        return answer;
    }
}