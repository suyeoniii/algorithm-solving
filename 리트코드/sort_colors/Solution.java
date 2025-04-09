package sort_colors;

/**
 * 2, 3번 풀이는 시간 비슷함
 */
class Solution {
    /**
     * 버블정렬
     * O(n^2)
     */
    public void sortColors(int[] nums) {
        // 버블정렬
        for(int i = 0; i<nums.length - 1; i++){
            for(int j = i+1; j<nums.length; j++){
                // swap
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 개수 세기
     * O(2n)
     */
    public void sortColors2(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;

        // 0, 1, 2 개수 세기
        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else if (num == 2) {
                two++;
            }
        }

        // 배열 만들기
        for(int i = 0; i<nums.length; i++){
            if (zero > 0) {
                nums[i] = 0;
                zero--;
            } else if (one > 0) {
                nums[i] = 1;
                one--;
            } else if (two > 0) {
                nums[i] = 2;
                two--;
            }
        }
    }

    /**
     * 포인터 3개 사용
     */
    public void sortColors3(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;

        while(mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, mid++, left++);
            } else if (nums[mid] == 1) {
                mid++;
            }
            else if (nums[mid] == 2) {
                swap(nums, mid, right--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}