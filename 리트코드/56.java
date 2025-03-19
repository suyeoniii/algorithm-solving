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