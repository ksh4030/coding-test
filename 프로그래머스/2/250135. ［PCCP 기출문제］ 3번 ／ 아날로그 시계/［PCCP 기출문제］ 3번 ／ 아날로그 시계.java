class Solution {
    private static long totalUpTo(long T) {
        // 0초부터 T초까지(포함) 알람 총 횟수
        long sm = (T * 59) / 3600 + 1;      // 초-분
        long sh = (T * 719) / 43200 + 1;    // 초-시
        long all = (T / 43200) + 1;         // 세 바늘 동시 (중복 제거용)
        return sm + sh - all;
    }

    private static int startHits(long T) {
        // 시작 시각에 바로 울리면 +1 (정각마다 초-분 겹침)
        return (T % 3600 == 0) ? 1 : 0;
    }

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        long t1 = h1 * 3600L + m1 * 60L + s1;
        long t2 = h2 * 3600L + m2 * 60L + s2;

        long ans = totalUpTo(t2) - totalUpTo(t1) + startHits(t1);
        return (int) ans;
    }
}
