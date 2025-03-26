import java.util.Arrays;

/**
 * 시간 복잡도
 * 1. 문자열로 변환 = N
 * 2. 정렬 = N log N
 * 3.
 * ---
 * 공간 복잡도: N
 * - strNums
 */
class LargestNumber {
    public String solution(int[] nums) {
        // 1. 문자열로 변환
        String[] strNums = new String[nums.length];
        for(int i = 0; i<nums.length; i++){
            strNums[i] = Integer.toString(nums[i]);
        }

        // 2. 정렬
        Arrays.sort(strNums, (a, b) -> {
            // 두 숫자를 앞+뒤, 뒤+앞 으로 이어붙여서 큰 순서대로 정렬. 사전식 비교
            return (b + a).compareTo(a + b);
        });

        // 가장 큰 수가 0인 경우는 답이 0
        if (strNums[0].equals("0")) {
            return "0";
        }

        // 답 생성
        StringBuilder sb = new StringBuilder(); // StringBuilder는 변경 가능한 객체, String은 불변 객체
        for(String str: strNums) {
            sb.append(str);
        }

        // 결과 반환
        return sb.toString();
    }

    public static void main(String[] args) {
        // 예시 숫자 배열
        int[] nums = {3, 30, 34, 5, 9};

        // 클래스 인스턴스 생성
        LargestNumber largestNumber = new LargestNumber();

        // solution 메서드 호출하여 결과 출력
        System.out.println(largestNumber.solution(nums)); // "9534330" 출력
    }
}