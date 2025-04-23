/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const map = new Map()

    for(let i = 0; i<strs.length; i++) {
        const sortedStr = strs[i].split('').sort().join('')
        const value = map.get(sortedStr) ?? []
        value.push(strs[i])
        map.set(sortedStr, value)
    }

    const arr = Array.from(map)
    const answer = arr.map((e) => e[1])

    return answer
};

/**
 * 개선된 방법: Object를 사용하여 Map 대신 처리하고, 
 * 결과를 직접 Object.values()로 변환해 중간 배열 생성 단계를 줄임
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagramsImproved = function(strs) {
    const result = {};

    for (const str of strs) {
        // 문자열을 정렬하여 애너그램 키 생성
        const sortedStr = str.split('').sort().join('');
        
        // 키가 존재하지 않으면 새 배열 생성, 존재하면 기존 배열에 추가
        if (!result[sortedStr]) {
            result[sortedStr] = [str];
        } else {
            result[sortedStr].push(str);
        }
    }

    // Object.values()로 직접 값 배열 반환
    return Object.values(result);
};

/**
 * 문자 카운트 방식으로 정렬 없이 애너그램 그룹화
 * 정렬 대신 각 문자의 발생 횟수를 계산해 키로 사용
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagramsOptimal = function(strs) {
    const result = {};

    for (const str of strs) {
        // 알파벳 빈도수 배열 (a-z)
        const count = new Array(26).fill(0);
        
        // 각 문자의 빈도수 계산
        for (let i = 0; i < str.length; i++) {
            count[str.charCodeAt(i) - 'a'.charCodeAt(0)]++;
        }
        
        // 빈도수 배열을 키로 사용 (예: "1#0#2#0..." 형태)
        const key = count.join('#');
        
        if (!result[key]) {
            result[key] = [str];
        } else {
            result[key].push(str);
        }
    }

    return Object.values(result);
};

// 모듈로 내보내기
module.exports = {
    groupAnagrams,
    groupAnagramsImproved,
    groupAnagramsOptimal
};