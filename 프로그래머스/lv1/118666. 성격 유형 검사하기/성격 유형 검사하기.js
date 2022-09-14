function solution(survey, choices) {
    var answer = '';
    let type = ['RT', 'CF', 'JM', 'AN']
    let score = new Map()
    
    // 점수 계산
    for(let i = 0; i<survey.length; i++){
        if(choices[i] === 4){
            continue;
        }
        else if(choices[i] >= 1 && choices[i] <= 3){
            let arr = [3, 2, 1]
            score.set(survey[i].charAt(0), (score.get(survey[i].charAt(0)) ?? 0) + arr[choices[i]-1])
        }
        else {
            score.set(survey[i].charAt(1), (score.get(survey[i].charAt(1)) ?? 0) + choices[i]-4)
        }
    }
    
    // 성격유형 구하기
    for(let t of type){
        if((score.get(t.charAt(0)) ?? 0) < score.get(t.charAt(1)) ?? 0){
            answer += t.charAt(1)
        }
        else{
            answer += t.charAt(0)
        }
        
    }
    return answer
}