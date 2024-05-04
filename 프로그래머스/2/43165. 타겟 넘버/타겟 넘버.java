class Solution {
    static int answer;
    static int t;
    public int solution(int[] numbers, int target) {
        answer = 0;
        t = target;
        int sum = 0;
        
        dfs(numbers, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int idx, int sum) {
        if(idx == numbers.length) {
            if(sum == t) {
                answer++;
            }
            
            return;
        }
        
        dfs(numbers, idx+1, sum + numbers[idx]);
        dfs(numbers, idx+1, sum - numbers[idx]);
    }
    
    
}