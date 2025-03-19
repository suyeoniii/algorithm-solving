class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] answer = new int[10001][2]; // 정답 배열

        // 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 답 배열에 첫번째 요소 추가
        answer[0][0] = intervals[0][0];
        answer[0][1] = intervals[0][1];

        int length = 1; // 정답에 추가된 항목 개수

        for(int i = 1; i<intervals.length; i++){
            // 겹치는 경우
            if (answer[length - 1][0] <= intervals[i][0] && intervals[i][0] <= answer[length - 1][1]) {
                // 정답 배열 마지막 값 수정
                answer[length - 1][1] = intervals[i][1];
            } else {
                // 안 겹치는 경우
                answer[length][0] = intervals[i][0];
                answer[length][1] = intervals[i][1];

                length++;
            }
        }

        // 값이 있는 값까지 잘라서 반환
        return Arrays.copyOf(answer, length);
    }
}

// 개선된 버전 (ArrayList 사용)
class Solution2 {
    public int[][] merge(int[][] intervals) {
        // 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // 첫 번째 구간 추가
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.get(merged.size() - 1); // 마지막 요소

            // 겹치는 경우, 최대값으로 병합
            if (last[1] >= intervals[i][0]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                // 안 겹치는 경우 새 구간 추가
                merged.add(intervals[i]);
            }
        }

        // List -> 배열 변환
        return merged.toArray(new int[merged.size()][]);
    }
}
