class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;

        for (int i = 3; i < sum; i++) {
            int n = sum / i;

            if(n >= 3 && sum % i == 0) {
                answer[0] = Math.max(i, n);
                answer[1] = Math.min(i, n);
                int y = (answer[0] - 2) * (answer[1] - 2);

                if(y == yellow) {
                    return answer;
                }
            }
        }
        
        return answer;
    }
}