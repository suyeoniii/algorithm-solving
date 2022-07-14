function solution(n) {
    var answer = String(n).substr(0, 1);
    
    for(let i = 1; i<String(n).length; i++){
        for(let j = 0; j<String(answer).length; j++){
            //더 큰숫자인 경우 - 앞자리에 놓기
            if(Number(String(answer).substr(j, 1)) <= Number(String(n).substr(i, 1))){
                answer = String(answer).substr(0, j) + String(n).substr(i, 1) + String(answer).substr(j)
                break;
            }
            if(j === String(answer).length-1){
                answer = answer + String(n).substr(i, 1);
                break;
            }
        }
    }
    
    return Number(answer);
}