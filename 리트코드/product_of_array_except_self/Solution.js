/**
 * @param {number[]} nums
 * @return {number[]}
 * 시간 복잡도: O(n)
 */
var productExceptSelf = function(nums) {
    let totalProduct = 1; // 전체 곱
    let zeroCount = 0; // 0의 개수
    const answer = [];

    // 전체 요소 곱해주기
    for(let i = 0; i<nums.length; i++){
        if (nums[i] === 0) {
            zeroCount++; // 0 개수 카운트
        } else {
            totalProduct *= nums[i]
        }   
    }

    // 해당 위치의 값으로 나누기
    for(let i = 0; i<nums.length; i++){
        // 0이면
        if (nums[i] === 0) {
            if (zeroCount > 1) { // 이 값 외에 0이 있는 경우
                answer.push(0);
            } else { // 이 값만 0인 경우
                answer.push(totalProduct)
            }
        } else {
            if (zeroCount > 0) { // 이 값 외에 0이 있는 경우
                answer.push(0);
            } else { // 0이 없는 경우
                answer.push(totalProduct / nums[i])
            }
        }        
    }

    return answer;
};

/**
 * @param {number[]} nums
 * @return {number[]}
 * 시간 복잡도: O(n)
 */
var productExceptSelf2 = function(nums) {
    const n = nums.length;
    const answer = new Array(n).fill(1);

    let leftProduct = 1;
    for(let i = 0; i<n; i++){
        answer[i] = leftProduct;
        leftProduct *= nums[i];
    }

    let rightProduct = 1;
    for(let i = n - 1; i>=0; i--) {
        answer[i] *= rightProduct;
        rightProduct *= nums[i];
    }

    return answer;
};