class Solution {
    int solution(int[][] land) {
        int n = land.length;
        
        // 첫 번째 행부터 시작하여 점수를 갱신해 나갑니다.
        for (int i = 1; i < n; i++) {
            // 이전 행의 각 열을 기준으로, 같은 열을 제외한 최대값을 더해줍니다.
            for (int j = 0; j < 4; j++) {
                int maxPrev = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        maxPrev = Math.max(maxPrev, land[i - 1][k]);
                    }
                }
                land[i][j] += maxPrev;
            }
        }
        
        // 마지막 행에서의 최대값을 구합니다.
        int answer = 0;
        for (int j = 0; j < 4; j++) {
            answer = Math.max(answer, land[n - 1][j]);
        }
        
        return answer;
    }
}
