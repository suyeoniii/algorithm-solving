import java.util.HashMap;

class Solution {
    
    public int solution(String dirs) {
        // 방향정보
        int[] dx = {0, -1, 1, 0};
        int[] dy = {1, 0, 0, -1};
        String d = "ULRD";
        
        // 현재위치
        int x = 0;
        int y = 0;
        
        // 방문한길 저장할 Map (예시 key=0001) -> 0, 0 -> 0, 1 이동 (x, y)
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        
        for(char c : dirs.toCharArray()){
            int index = d.indexOf(c);
            String move = Integer.toString(x) + Integer.toString(y);
            
            // 경계를 넘어가지 않는 경우 x,y 좌표 업데이트
            if(x+dx[index] >= -5 && x+dx[index] <= 5
               && y+dy[index] >= -5 && y+dy[index] <= 5){
                x += dx[index];
                y += dy[index];
            } else {
                continue;
            }
            
            // 이동, 경로기록 (양방향 기록)
            m.put(move + Integer.toString(x) + Integer.toString(y), 1);
            m.put(Integer.toString(x) + Integer.toString(y) + move, 1);
        }
        
        return m.size() / 2; // 양방향 제거
    }
}