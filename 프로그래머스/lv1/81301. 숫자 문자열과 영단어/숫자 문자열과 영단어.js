function solution(s) {
    var answer = "";
    
    const number = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    
    for(let i = 0; i<s.length; i++){
        if(s[i] >= "0" && s[i] <= "9"){
            answer += s[i];
        }
        else{
            var word = s.substring(i, i+3);
            
            for(let j in number){
                if(word === number[j].substring(0,3)){
                    answer += j.toString();
                    //i += number[j].length;
                    break;
                }
            }
        }
    }
    
    return parseInt(answer);
}