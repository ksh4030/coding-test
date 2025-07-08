import java.util.*;

class Solution {
    public int solution(int[] a) {
        if (a.length < 2) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : a) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int max = 0;

        // 중심값 후보로 모든 숫자를 시도
        for (int key : freq.keySet()) {
            // 중심값으로 만들 수 있는 쌍의 수가 전체 쌍의 수보다 많을 수는 없음
            if (freq.get(key) * 2 <= max) continue;

            int count = 0;
            for (int i = 0; i < a.length - 1; i++) {
                // 인접한 숫자가 서로 다르고
                if (a[i] != a[i + 1]) {
                    // 둘 중 하나가 중심값이어야 유효한 스타 쌍
                    if (a[i] == key || a[i + 1] == key) {
                        count++;
                        i++; // 이 쌍은 사용했으므로 다음으로 넘어감
                    }
                }
            }
            max = Math.max(max, count * 2);
        }

        return max;
    }
}
