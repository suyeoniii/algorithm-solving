class ValidPalindrome {

    /**
     * for문으로 구현 - 성능 하위
     * ---
     * 시간 복잡도
     * 1. 정규식으로 문자만 처리 - replaceAll - N
     * 2. 소문자로 변환 - toLowerCase - N
     * 3. 팰린드롬 판별 - for문 - N/2
     * -> O(N)
     * ---
     * 공간 복잡도
     * s의 길이 N
     * text - N
     * mid - 1
     * -> O(N)
     */
    public boolean isPalindrome1(String s) {
        // 문자만 추출
        String text = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 빈문자열 반환
        if (text.isEmpty()) {
            return true;
        }

        // 가운데 index
        int mid = text.length() / 2;

        // 팰린드롬 판별
        for(int i = 0; i<mid; i++){
            // 양쪽 문자 순차적으로 비교
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                // 일치하지 않는 경우 반환
                return false;
            }
        }

        // 위에서 반환되지 않은 경우 모두 일치하므로 true
        return true;
    }

    /**
     * 투 포인터 사용 (성능 상위)
     * ---
     * 시간 복잡도
     * - while문 - 2/N -> O(N)
     * ---
     * 공간 복잡도
     * - left, right 변수 - 각각 1
     * -> O(1)
     */
    class isPalindrome2 {
        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while(left < right) {
                // left 포인터가 가리키는 공백, 문자열 스킵
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                }

                // right 포인터가 가리키는 공백, 문자열 스킵
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }
                // 소문자 기준으로 비교
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }

                // 포인터 이동
                left++;
                right--;
            }

            return true;
        }
    }
}
