import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        // 포인트 번호 → 좌표 매핑
        Map<Integer, int[]> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, points[i]);
        }

        // 시간대별 위치 기록: Map<시간, Map<"r,c", 개수>>
        Map<Integer, Map<String, Integer>> timePositionMap = new HashMap<>();

        // 각 로봇별 경로 계산 및 시간대별 위치 기록
        for (int[] route : routes) {
            List<String> path = new ArrayList<>();

            for (int i = 0; i < route.length - 1; i++) {
                int[] start = pointMap.get(route[i]);
                int[] end = pointMap.get(route[i + 1]);

                int r1 = start[0], c1 = start[1];
                int r2 = end[0], c2 = end[1];

                // r 우선 이동
                while (r1 != r2) {
                    path.add(r1 + "," + c1);
                    r1 += (r1 < r2) ? 1 : -1;
                }
                // c 이동
                while (c1 != c2) {
                    path.add(r1 + "," + c1);
                    c1 += (c1 < c2) ? 1 : -1;
                }
            }

            // 마지막 위치 추가
            int[] last = pointMap.get(route[route.length - 1]);
            path.add(last[0] + "," + last[1]);

            // 시간별 위치 기록
            for (int t = 0; t < path.size(); t++) {
                String pos = path.get(t);
                timePositionMap.putIfAbsent(t, new HashMap<>());
                Map<String, Integer> posCount = timePositionMap.get(t);
                posCount.put(pos, posCount.getOrDefault(pos, 0) + 1);
            }
        }

        // 충돌 위험 카운트
        int dangerCount = 0;
        for (Map<String, Integer> positions : timePositionMap.values()) {
            for (int count : positions.values()) {
                if (count >= 2) {
                    dangerCount++;
                }
            }
        }

        return dangerCount;
    }
}
