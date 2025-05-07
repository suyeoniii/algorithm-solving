const { intersection, intersection2 } = require('./Solution');

// 다양한 크기의 테스트 케이스 생성 함수
function generateTestCase(size, overlap = 0.5) {
  const nums1 = Array.from({ length: size }, (_, i) => i);
  const nums2 = Array.from({ length: size }, (_, i) =>
    i < size * overlap ? i : i + size
  );
  return { nums1, nums2 };
}

// 테스트 케이스 목록
const testCases = [
  { nums1: [1, 2, 2, 1], nums2: [2, 2], desc: '작은 배열' },
  { nums1: [4, 9, 5], nums2: [9, 4, 9, 8, 4], desc: '작은 배열2' },
  { ...generateTestCase(100), desc: '중간 크기(100)' },
  { ...generateTestCase(10000), desc: '큰 배열(10,000)' },
  { ...generateTestCase(100000, 0.1), desc: '매우 큰 배열(100,000), 10% 겹침' },
];

// 성능 측정 함수
function measureTime(fn, nums1, nums2, repeat = 10) {
  const start = process.hrtime.bigint();
  for (let i = 0; i < repeat; i++) {
    fn(nums1, nums2);
  }
  const end = process.hrtime.bigint();
  return Number(end - start) / 1e6; // ms 단위
}

for (const { nums1, nums2, desc } of testCases) {
  console.log(`\n[${desc}]`);
  // 정확성 체크 (작은 케이스만)
  if (nums1.length < 20) {
    const result1 = intersection(nums1, nums2);
    const result2 = intersection2(nums1, nums2);
    console.log('intersection:', result1);
    console.log('intersection2:', result2);
  }
  // 성능 체크
  const repeat = nums1.length < 1000 ? 10000 : 10;
  const t1 = measureTime(intersection, nums1, nums2, repeat);
  const t2 = measureTime(intersection2, nums1, nums2, repeat);
  console.log(`intersection:  ${t1.toFixed(2)} ms (${repeat}회 반복)`);
  console.log(`intersection2: ${t2.toFixed(2)} ms (${repeat}회 반복)`);
}