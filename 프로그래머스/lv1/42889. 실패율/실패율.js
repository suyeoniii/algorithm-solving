function solution(N, stages) {
    var answer = []
    let rate = new Array(N).fill(new Array(2).fill(0))
    
    // 스테이지별 클리어 횟수
    let arr = new Array(N+1).fill(0)
    for(let s of stages){
        arr[s-1] += 1
    }
    
    // 실패율
    let total = arr[N];
    for(let i = N-1; i>= 0; i--){
        total += arr[i]
        rate[i] = [arr[i]/total || 0, i]
    }

    // 실패율따라 정렬
    rate.sort((a, b) => {
        if(a[0] === b[0]){
            return b[1]-a[1]
        }
        return a[0]-b[0]
    })
    
    // 정답배열 생성
    for(let i = N-1; i>=0; i--){
        answer.push(rate[i][1]+1)
    }
    
    return answer;
}