package sort_colors;

import org.junit.jupiter.api.Test;
import java.util.Random;
import java.util.Arrays;

public class SolutionTest {
    private final Solution solution = new Solution();
    private final Random random = new Random();

    @Test
    void testPerformance() {
        // 테스트할 배열 크기들
        int[] sizes = {100, 1000, 10000, 100000};
        
        for (int size : sizes) {
            int[] arr1 = generateRandomArray(size);
            int[] arr2 = arr1.clone();
            int[] arr3 = arr1.clone();
            
            System.out.println("\nTesting with array size: " + size);
            
            // 첫 번째 방법 (버블 정렬) 테스트
            long startTime = System.nanoTime();
            solution.sortColors(arr1);
            long endTime = System.nanoTime();
            double duration1 = (endTime - startTime) / 1_000_000.0;
            System.out.println("Method 1 (Bubble Sort) execution time: " + duration1 + " ms");
            
            // 두 번째 방법 (카운팅) 테스트
            startTime = System.nanoTime();
            solution.sortColors2(arr2);
            endTime = System.nanoTime();
            double duration2 = (endTime - startTime) / 1_000_000.0;
            System.out.println("Method 2 (Counting) execution time: " + duration2 + " ms");
            
            // 세 번째 방법 (3 포인터) 테스트
            startTime = System.nanoTime();
            solution.sortColors3(arr3);
            endTime = System.nanoTime();
            double duration3 = (endTime - startTime) / 1_000_000.0;
            System.out.println("Method 3 (Three Pointers) execution time: " + duration3 + " ms");
            
            // 결과가 모두 같은지 확인
            assert Arrays.equals(arr1, arr2) && Arrays.equals(arr2, arr3) : "Sorting results are different!";
        }
    }
    
    private int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(3); // 0, 1, 2 중 랜덤 값 생성
        }
        return arr;
    }
}
