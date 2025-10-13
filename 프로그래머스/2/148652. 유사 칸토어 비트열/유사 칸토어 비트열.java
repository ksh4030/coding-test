class Solution {
    public int solution(int n, long l, long r) {
        return cntOne(n, l - 1, r - 1);
    }

    private int cntOne(int n, long l, long r) {
        if (n == 0) return (l == 0 && r == 0) ? 1 : 0;

        int cnt = 0;
        long len = (long) Math.pow(5, n - 1);

        for (long i = l; i <= r; i++) {
            long x = (i / len) % 5;

            if (x == 2) continue;
            else cnt += cntOne(n - 1, i % len, i % len);
        }
        return cnt;
    }
}


// S_0 = [1]
// S_1 = [11011]
// S_2 = [11011 11011 00000 11011 11011]
// S_n = [S_n-1, S_n-1, 00000..., S_n-1, S_n-1 ]
