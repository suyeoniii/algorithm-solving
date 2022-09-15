function solution(n, m) {
    var answer = [0, 0];
    
    let mi = Math.min(n, m)
    let mul = n*m
    
    // 최대공약수
    for(let i = 1; i<=mi; i++){
        if(n%i===0 && m%i === 0){
            answer[0] = i;
        }
    }
    // 최소공배수
    for(let i = mul; i>1; i--){
        if(i%n === 0 && i%m === 0){
            answer[1] = i;
        }
    }
    
    return answer;
}