function solution(citations) {
    var answer = 0;
    citations.sort((a, b) => Number(a) - Number(b));
    
    for(let i = 0; i<citations.length; i++){
        if(citations[i] >= citations.length - i){
            answer = citations.length - i;
            break;
        }
    }
    
    return answer;
}