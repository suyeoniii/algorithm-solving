function solution(n) {
    let answer = 0;
    
    if(n===1) answer = 4;
    else {
        for(let i = 0; i<n; i++){
        //console.log(i)
        if(n/i===i){
            answer = (i+1)*(i+1);
                break;
        }
    }
    }
    
    
    return answer ? answer : -1
}