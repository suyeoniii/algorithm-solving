/**
 * @param {number[]} nums
 * @return {number}
 * 시간 복잡도: n log n + n = O(n log n)
 */
var arrayPairSum = function(nums) {
    let answer = 0;
    nums = nums.sort((a, b) => a - b); // 그냥 sort하면 음수 처리 안됨 (문자열 정렬돼서)

    for(let i = 0; i<nums.length; i+=2){
        answer += nums[i];
    }

    return answer;
};