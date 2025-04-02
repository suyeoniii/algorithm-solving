import java.util.Arrays;

class ValidAnagram {
    // 정렬
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        if (String.valueOf(sArr).equals(String.valueOf(tArr))) {
            return true;
        }

        return false;
    }

    // Map
}
