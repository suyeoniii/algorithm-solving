package reorder_data_in_log_files;

import java.util.Arrays;

class Solution {

    /**
     * 개선 전 풀이
     * Test: 79ms ~ 88ms
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {

        // O(n log n * L)
        Arrays.sort(logs, (a, b) -> {
            String[] splitedA = a.split(" "); // O(n)
            String[] splitedB = b.split(" "); // O(n)
            String joinedA = String.join(" ", Arrays.copyOfRange(splitedA, 1, splitedA.length)); // O(L) + O(n)
            String joinedB = String.join(" ", Arrays.copyOfRange(splitedB, 1, splitedB.length)); // O(L) + O(n)

            boolean isDigitA = joinedA.matches("[\\d\\s]+"); // O(n)
            boolean isDigitB = joinedB.matches("[\\d\\s]+"); // O(n)

            // 숫자인지 문자인지
            if (isDigitA && !isDigitB) {
                return 1;
            } else if (!isDigitA && isDigitB) {
                return -1;
            } else if (!isDigitA && !isDigitB) {
                if (joinedA.equals(joinedB)) { // O(L)
                    return splitedA[0].compareTo(splitedB[0]);
                }
                return joinedA.compareTo(joinedB);
            } else {
                return 0;
            }
        });
        return logs;
    }

    /**
     * 개선 후 버전
     * Test: 15ms ~ 30ms
     * @param logs
     * @return
     */
    public String[] reorderLogFiles2(String[] logs) {
        // O(n log n * L)
        // L은 문자 평균 길이
        Arrays.sort(logs, (a, b) -> {
            // 공백기준으로 두 부분으로 나누기
            String[] splitA = a.split(" ", 2); // O(L), split 대신 substring 쓰는 방식이 성능이 더 좋음
            String[] splitB = b.split(" ", 2);

            // 식별자와 정렬할 내용 변수처리
            String idA = splitA[0]; // O(1)
            String contentA = splitA[1];
            String idB = splitB[0];
            String contentB = splitB[1];

            // 문자인지 숫자인지 여부
            boolean isDigitA = Character.isDigit(contentA.charAt(0)); // O(1)
            boolean isDigitB = Character.isDigit(contentB.charAt(0));

            // 정렬
            // 1. 둘 다 숫자인 경우 → 순서 유지
            if (isDigitA && isDigitB) return 0;

            // 2. A는 문자, B는 숫자 → A가 앞
            if (!isDigitA && isDigitB) return -1;

            // 3. A는 숫자, B는 문자 → B가 앞
            if (isDigitA) return 1;

            // 4. 둘 다 문자 → 내용 기준 비교, 같으면 ID 기준
            int cmp = contentA.compareTo(contentB); // O(L)
            if (cmp != 0) return cmp;
            return idA.compareTo(idB);
        });

        return logs;
    }

    /**
     * 개선 후 버전
     * Test: 15ms ~ 30ms
     * @param logs
     * @return
     */
    public String[] reorderLogFiles3(String[] logs) {
        if (logs.length < 2) {
            return logs;
        }
        // O(n log n * L)
        // L은 문자 평균 길이
        Arrays.sort(logs, (a, b) -> {
            // 공백기준으로 두 부분으로 나누기
            String[] splitA = a.split(" ", 2); // O(L), split 대신 substring 쓰는 방식이 성능이 더 좋음
            String[] splitB = b.split(" ", 2);

            // 식별자와 정렬할 내용 변수처리
            String idA = splitA[0]; // O(1)
            String contentA = splitA[1];
            String idB = splitB[0];
            String contentB = splitB[1];

            // 문자인지 숫자인지 여부
            boolean isDigitA = Character.isDigit(contentA.charAt(0)); // O(1)
            boolean isDigitB = Character.isDigit(contentB.charAt(0));

            // 정렬
            // 1. 둘 다 숫자인 경우 → 순서 유지
            if (isDigitA && isDigitB) return 0;

            // 2. A는 문자, B는 숫자 → A가 앞
            if (!isDigitA && isDigitB) return -1;

            // 3. A는 숫자, B는 문자 → B가 앞
            if (isDigitA) return 1;

            // 4. 둘 다 문자 → 내용 기준 비교, 같으면 ID 기준
            int cmp = contentA.compareTo(contentB); // O(L)
            if (cmp != 0) return cmp;
            return idA.compareTo(idB);
        });

        return logs;
    }
}