package most_common_word;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 다양한 테스트 케이스 준비
        TestCase[] testCases = {
            // 케이스 1: 간단한 입력
            new TestCase(
                "Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"},
                "간단한 입력"
            ),
            
            // 케이스 2: 반복 단어가 많은 경우
            new TestCase(
                "a a a a b b b c c d d d d d d d d",
                new String[]{"a"},
                "반복 단어가 많은 경우"
            ),
            
            // 케이스 3: 금지어가 많은 경우
            new TestCase(
                "Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit", "ball", "the", "a", "bob"},
                "금지어가 많은 경우"
            ),
            
            // 케이스 4: 긴 텍스트 (반복 적용)
            new TestCase(
                generateRepeatedText("Bob hit a ball, the hit BALL flew far after it was hit. ", 1000),
                new String[]{"hit"},
                "긴 텍스트"
            ),
            
            // 케이스 5: 매우 긴 텍스트에 많은 금지어
            new TestCase(
                generateRepeatedText("Bob hit a ball, the hit BALL flew far after it was hit. ", 5000),
                new String[]{"hit", "ball", "the", "a", "it", "flew", "far", "after", "was"},
                "매우 긴 텍스트에 많은 금지어"
            ),
            
            // 케이스 6: 특수문자가 많은 경우
            new TestCase(
                "Bob, hit! a. ball; the hit BALL!!!??? flew, far..... after--it was-hit.",
                new String[]{"hit"},
                "특수문자가 많은 경우"
            ),
            
            // 케이스 7: 단어가 없는 금지어
            new TestCase(
                "Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"xyz", "123", "not-exist"},
                "단어가 없는 금지어"
            )
        };
        
        // 각 테스트 케이스에 대해 실행
        for (TestCase testCase : testCases) {
            System.out.println("\n===== 테스트 케이스: " + testCase.description + " =====");
            TestCase.setCurrentTestCase(testCase);
            runAllMethods(solution, testCase.paragraph, testCase.banned);
        }
        
        // 전체 결과 요약 출력
        System.out.println("\n===== 종합 실행 시간 요약 =====");
        System.out.println("테스트 케이스 개수: " + testCases.length);
        System.out.println(String.format("%-25s %-15s %-15s %-15s %-15s", 
                "테스트 케이스", "메소드1(ms)", "메소드2(ms)", "메소드3(ms)", "메소드4(ms)"));
        
        for (TestCase testCase : testCases) {
            System.out.println(String.format("%-25s %-15d %-15d %-15d %-15d", 
                    testCase.description,
                    testCase.duration1,
                    testCase.duration2,
                    testCase.duration3,
                    testCase.duration4));
        }
    }
    
    private static void runAllMethods(Solution solution, String paragraph, String[] banned) {
        String[] results = new String[4];
        long[] durations = new long[4];
        
        // 첫 번째 메소드
        long startTime = System.nanoTime();
        results[0] = solution.mostCommonWord(paragraph, banned);
        long endTime = System.nanoTime();
        durations[0] = (endTime - startTime) / 1000000; // 밀리초 단위 변환
        
        // 두 번째 메소드
        startTime = System.nanoTime();
        results[1] = solution.mostCommonWord2(paragraph, banned);
        endTime = System.nanoTime();
        durations[1] = (endTime - startTime) / 1000000;
        
        // 세 번째 메소드
        startTime = System.nanoTime();
        results[2] = solution.mostCommonWord3(paragraph, banned);
        endTime = System.nanoTime();
        durations[2] = (endTime - startTime) / 1000000;
        
        // 네 번째 메소드
        startTime = System.nanoTime();
        results[3] = solution.mostCommonWord4(paragraph, banned);
        endTime = System.nanoTime();
        durations[3] = (endTime - startTime) / 1000000;
        
        // 실행 시간 출력
        System.out.println("mostCommonWord  실행 시간: " + durations[0] + " ms, 결과: " + results[0]);
        System.out.println("mostCommonWord2 실행 시간: " + durations[1] + " ms, 결과: " + results[1]);
        System.out.println("mostCommonWord3 실행 시간: " + durations[2] + " ms, 결과: " + results[2]);
        System.out.println("mostCommonWord4 실행 시간: " + durations[3] + " ms, 결과: " + results[3]);
        
        // 결과가 모두 동일한지 확인
        boolean allSame = results[0].equals(results[1]) && results[1].equals(results[2]) && results[2].equals(results[3]);
        if (!allSame) {
            System.out.println("⚠️ 결과 불일치! 메소드들이 서로 다른 결과를 반환했습니다.");
            System.out.println("  메소드1: " + results[0]);
            System.out.println("  메소드2: " + results[1]);
            System.out.println("  메소드3: " + results[2]);
            System.out.println("  메소드4: " + results[3]);
        }
        
        // 테스트 케이스에 실행 시간 저장
        TestCase tc = TestCase.getCurrentTestCase();
        if (tc != null) {
            tc.duration1 = durations[0];
            tc.duration2 = durations[1];
            tc.duration3 = durations[2];
            tc.duration4 = durations[3];
        }
    }
    
    // 반복된 텍스트 생성
    private static String generateRepeatedText(String text, int repetitions) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < repetitions; i++) {
            builder.append(text);
        }
        return builder.toString();
    }
    
    // 테스트 케이스 클래스
    static class TestCase {
        String paragraph;
        String[] banned;
        String description;
        long duration1;
        long duration2;
        long duration3;
        long duration4;
        
        // 현재 실행중인 테스트 케이스를 추적하기 위한 스레드 로컬 변수
        private static ThreadLocal<TestCase> currentTestCase = new ThreadLocal<>();
        
        TestCase(String paragraph, String[] banned, String description) {
            this.paragraph = paragraph;
            this.banned = banned;
            this.description = description;
        }
        
        static TestCase getCurrentTestCase() {
            return currentTestCase.get();
        }
        
        static void setCurrentTestCase(TestCase testCase) {
            currentTestCase.set(testCase);
        }
    }
}
