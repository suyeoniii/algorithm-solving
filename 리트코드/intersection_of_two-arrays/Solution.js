/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
    const map = new Map();
    const answer = [];

    // 짧은 배열과 긴 배열 구분
    const [shortArr, longArr] = nums1.length < nums2.length ? [nums1, nums2] : [nums2, nums1];

    // 짧은 배열로 Map 생성
    for (const num of shortArr) {
        map.set(num, true);
    }

    // 긴 배열에서 Map에 존재하는 값만 추가 후 삭제
    for (const num of longArr) {
        if (map.has(num)) {
            answer.push(num);
            map.delete(num);
        }
    }

    return answer;
};


/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection2 = function(nums1, nums2) {
    const map = new Map()
    const answer = []

    for(num of nums1) {
        map.set(num, true)
    }

    for(num of nums2) {
        if (map.has(num)) {
            answer.push(num)
            map.delete(num)
        }
    }

    return answer
};

module.exports = {
    intersection,
    intersection2
}