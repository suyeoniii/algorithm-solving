const { performance } = require('perf_hooks');
const { groupAnagrams, groupAnagramsImproved, groupAnagramsOptimal } = require('./Solution');

/**
 * 함수 실행 시간을 측정하는 유틸리티 함수
 * @param {Function} fn - 실행할 함수
 * @param {Array} args - 함수에 전달할 인자들
 * @returns {Object} - 결과와 실행 시간을 포함한 객체
 */
function measurePerformance(fn, args) {
  const start = performance.now();
  const result = fn(...args);
  const end = performance.now();
  return {
    result,
    executionTime: end - start
  };
}

/**
 * 문자열 배열을 생성하는 유틸리티 함수
 * @param {number} size - 생성할 배열의 크기
 * @param {number} strLength - 각 문자열의 길이
 * @returns {Array<string>} - 생성된 문자열 배열
 */
function generateStringArray(size, strLength = 5) {
  const chars = 'abcdefghijklmnopqrstuvwxyz';
  const result = [];
  
  for (let i = 0; i < size; i++) {
    let str = '';
    for (let j = 0; j < strLength; j++) {
      str += chars.charAt(Math.floor(Math.random() * chars.length));
    }
    result.push(str);
  }
  
  return result;
}

/**
 * 애너그램을 포함한 테스트 케이스를 생성하는 함수
 * @param {number} size - 생성할 배열의 크기
 * @returns {Array<string>} - 애너그램을 포함한 문자열 배열
 */
function generateAnagramTestCase(size) {
  const baseArray = generateStringArray(Math.floor(size / 3), 5);
  const result = [...baseArray];
  
  // 원본 문자열의 애너그램을 추가
  for (let i = 0; i < baseArray.length; i++) {
    if (i % 2 === 0) { // 절반의 문자열만 애너그램 추가
      const anagram = baseArray[i].split('').sort(() => 0.5 - Math.random()).join('');
      result.push(anagram);
    }
  }
  
  // 나머지 배열을 무작위 문자열로 채움
  while (result.length < size) {
    result.push(generateStringArray(1)[0]);
  }
  
  // 배열 섞기
  return result.sort(() => 0.5 - Math.random());
}

// 테스트 케이스 정의
const testCases = [
  {
    name: "기본 예제",
    input: ["eat", "tea", "tan", "ate", "nat", "bat"]
  },
  {
    name: "빈 입력",
    input: [""]
  },
  {
    name: "작은 데이터셋",
    input: generateAnagramTestCase(100)
  },
  {
    name: "중간 데이터셋",
    input: generateAnagramTestCase(1000)
  },
  {
    name: "큰 데이터셋",
    input: generateAnagramTestCase(5000)
  }
];

// 테스트 실행 및 결과 출력
console.log("========== 그룹 애너그램 성능 테스트 ==========");

testCases.forEach(({ name, input }) => {
  console.log(`\n----- ${name} -----`);
  console.log(`데이터 크기: ${input.length}`);
  
  const { executionTime: time1 } = measurePerformance(groupAnagrams, [input]);
  const { executionTime: time2 } = measurePerformance(groupAnagramsImproved, [input]);
  const { executionTime: time3 } = measurePerformance(groupAnagramsOptimal, [input]);
  
  console.log(`원본 방식 (Map + Array.from): ${time1.toFixed(3)}ms`);
  console.log(`개선 방식 (Object + values): ${time2.toFixed(3)}ms`);
  console.log(`최적 방식 (문자 카운트): ${time3.toFixed(3)}ms`);
  
  console.log(`개선 방식은 원본 대비: ${(time1 / time2).toFixed(2)}배 빠름`);
  console.log(`최적 방식은 원본 대비: ${(time1 / time3).toFixed(2)}배 빠름`);
});

// 결과 정확성 검증
function verifyResults() {
  console.log("\n========== 결과 정확성 검증 ==========");
  const testInput = ["eat", "tea", "tan", "ate", "nat", "bat"];
  
  const result1 = JSON.stringify(groupAnagrams(testInput).map(arr => arr.sort()).sort());
  const result2 = JSON.stringify(groupAnagramsImproved(testInput).map(arr => arr.sort()).sort());
  const result3 = JSON.stringify(groupAnagramsOptimal(testInput).map(arr => arr.sort()).sort());
  
  console.log("원본과 개선 방식 결과 일치:", result1 === result2);
  console.log("원본과 최적 방식 결과 일치:", result1 === result3);
}

verifyResults();
