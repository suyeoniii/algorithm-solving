import java.util.Arrays;

class Solution {
    private boolean[] visited = new boolean[51];
    private int answer = 0;
    
    public int solution(int[] nums) {
        go(nums, 0, 0);
        return answer;
    }
    
    public void go(int[] nums, int cnt, int n) {
        if(cnt == 3){
            int sum = 0;
            for(int i = 0; i<visited.length; i++){
                if(visited[i] == true){
                    sum += nums[i];
                }
            }
            
            for(int i = 2; i<sum/2; i++){
                if(sum % i == 0){
                    return;
                }
            }
            answer += 1;
            return;
        }
        
        for(int i = n; i<nums.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                go(nums, cnt + 1, i+1);
                visited[i] = false;
            }
        }
    }
}