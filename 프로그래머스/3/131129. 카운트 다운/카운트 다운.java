class Solution {
    public int[] solution(int target) {
        // dp 배열 초기화
        // darts[i]: i점을 만들기 위한 최소 다트 수
        // singles[i]: 그때 얻을 수 있는 싱글/불 개수 최댓값
        int[] darts = new int[target + 1];
        int[] singles = new int[target + 1];
        final int INF = Integer.MAX_VALUE;
        for (int i = 1; i <= target; i++) {
            darts[i] = INF;
            singles[i] = -1;
        }
        
        // 점수 옵션(1~20 싱글, 더블, 트리플 + 불(50점))
        int[] scores = new int[61];
        boolean[] isSingle = new boolean[61];
        int idx = 0;
        for (int num = 1; num <= 20; num++) {
            scores[idx] = num;       isSingle[idx++] = true;   // 싱글
            scores[idx] = 2 * num;   isSingle[idx++] = false;  // 더블
            scores[idx] = 3 * num;   isSingle[idx++] = false;  // 트리플
        }
        scores[idx] = 50; isSingle[idx++] = true;  // 불(50점, 싱글로 취급)
        
        // dp 채우기
        darts[0] = 0;
        singles[0] = 0;
        for (int i = 1; i <= target; i++) {
            int bestD = INF, bestS = -1;
            for (int k = 0; k < idx; k++) {
                int s = scores[k];
                if (s > i) continue;
                int prevD = darts[i - s];
                if (prevD == INF) continue;
                int candD = prevD + 1;
                int candS = singles[i - s] + (isSingle[k] ? 1 : 0);
                // 다트 수 작거나, 같으면 싱글 개수 많은 쪽을 택함
                if (candD < bestD || (candD == bestD && candS > bestS)) {
                    bestD = candD;
                    bestS = candS;
                }
            }
            darts[i] = bestD;
            singles[i] = bestS;
        }
        
        return new int[]{darts[target], singles[target]};
    }
}
