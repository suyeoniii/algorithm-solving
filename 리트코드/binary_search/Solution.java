package binary_search;

class Solution {
    /**
     * 그냥 칮기
     * 시간복잡도 O(N)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        for(int i = 0; i<nums.length; i++){
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Binary search로 풀이
     * 시간복잡도 (log n)
     */
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) { // 찾을 값이 큰 경우
                left = mid + 1;
            } else if (nums[mid] > target) { // 찾을 값이 작은 경우
                right = mid - 1;
            } else { // 같은 경우
                return mid;
            }
        }
        return -1;
    }
}