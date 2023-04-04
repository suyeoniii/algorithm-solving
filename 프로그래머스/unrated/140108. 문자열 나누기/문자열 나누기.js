function solution(s) {
    var answer = 0;
    
    let map = new Map()
    
    let reading = '';
    for(let word of s.split('')){
        if(reading == ''){
            reading = word;
        }
        map.set(word, map.has(word) ? map.get(word) + 1 : 1);
        let sum = 0;
        if(map.size > 1) {
            for(let entry of map){
                if(entry[0] != reading){
                    sum += entry[1];
                }
            }
            if(sum == map.get(reading)){
                answer += 1;
                reading = '';
                map.clear();
            }
        }
    }
    if(map.size){
        answer++;
    }
    
    return answer;
}