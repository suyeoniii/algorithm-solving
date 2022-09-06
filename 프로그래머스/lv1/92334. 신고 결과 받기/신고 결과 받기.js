function solution(id_list, report, k) {
  var answer = new Array(id_list.length).fill(0);
  let m = new Map();

  // report 배열 중복제거
  const uniqueReport = new Set(report)

  // 신고 배열 반복, 신고 count + 1
  for (let r of uniqueReport) {
    const [reporter, reportedId] = r.split(" ");

    let newReport = m.get(reportedId) || [];
    newReport.push(reporter);

    m.set(reportedId, newReport);
  }

  // 결과 배열 얻기
  for (let id of id_list) {
    if (m.get(id) && m.get(id).length >= k) {
      for (let reporter of m.get(id)) {
        answer[id_list.indexOf(reporter)]++;
      }
    }
  }
  return answer;
}