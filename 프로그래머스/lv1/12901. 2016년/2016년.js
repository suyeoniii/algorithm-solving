function solution(a, b) {
    const day = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
    const dayOfMonth = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    
    let numOfDate = 0
    let month = a-1;
    for(let i = 0; i < month; i++){
        numOfDate += dayOfMonth[i]
    }
    numOfDate += b-1
    
    return day[(numOfDate+5)%7];
}