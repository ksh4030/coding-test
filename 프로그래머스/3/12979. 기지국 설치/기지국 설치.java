class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int current = 1; // 현재 아파트 위치
        int range = 2 * w + 1; // 한 기지국이 커버할 수 있는 범위

        for (int station : stations) {
            // 기존 기지국이 커버하지 못하는 왼쪽 구간 계산
            if (current < station - w) {
                int leftCoverage = station - w - current;
                answer += Math.ceil((double) leftCoverage / range);
            }
            // 커버 가능한 범위의 다음 위치로 이동
            current = station + w + 1;
        }

        // 마지막 기지국 이후 커버하지 못한 구간 처리
        if (current <= n) {
            int remaining = n - current + 1;
            answer += Math.ceil((double) remaining / range);
        }

        return answer;
    }
}
