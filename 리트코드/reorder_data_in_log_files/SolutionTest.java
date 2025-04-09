package reorder_data_in_log_files;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void testBasicCase() {
        String[] input = {
            "dig1 8 1 5 1",
            "let1 art can",
            "dig2 3 6",
            "let2 own kit dig",
            "let3 art zero"
        };
        String[] expected = {
            "let1 art can",
            "let3 art zero",
            "let2 own kit dig",
            "dig1 8 1 5 1",
            "dig2 3 6"
        };
        assertArrayEquals(expected, solution.reorderLogFiles2(input));
    }

    @Test
    void testSameContentDifferentIdentifier() {
        String[] input = {
            "dig1 8 1 5 1",
            "let1 art can",
            "let2 art can"
        };
        String[] expected = {
            "let1 art can",
            "let2 art can",
            "dig1 8 1 5 1"
        };
        assertArrayEquals(expected, solution.reorderLogFiles2(input));
    }

    @Test
    void testPerformance() {
        // 대규모 테스트 데이터 생성
        int size = 10000;
        String[] largeLogs = new String[size];
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                largeLogs[i] = "let" + i + " art can do " + i;
            } else {
                largeLogs[i] = "dig" + i + " " + i + " " + (i+1) + " " + (i+2);
            }
        }

        // 성능 측정
        long startTime = System.nanoTime();
        solution.reorderLogFiles2(largeLogs);
        long endTime = System.nanoTime();
        
        double durationInMillis = (endTime - startTime) / 1_000_000.0;
        System.out.println("Performance Test with " + size + " logs:");
        System.out.println("Execution time: " + durationInMillis + " ms");
    }

    @Test
    void testEmptyAndSingleElement() {
        // 빈 배열 테스트
        assertArrayEquals(new String[]{}, solution.reorderLogFiles2(new String[]{}));
        
        // 단일 요소 테스트
        String[] singleInput = {"let1 art can"};
        assertArrayEquals(singleInput, solution.reorderLogFiles2(singleInput));
    }
} 