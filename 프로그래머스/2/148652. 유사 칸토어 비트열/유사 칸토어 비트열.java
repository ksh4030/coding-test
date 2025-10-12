import java.io.*;
import java.util.*;

class Solution {
    // pow5[i] = 5^i, ones[i] = 4^i = S_i 전체에서 1의 개수
    static long[] pow5 = new long[21];
    static long[] ones = new long[21];

    // n단계 비트열 S_n의 앞에서 x개(1-based가 아니라 길이 x) 안에 있는 1의 개수 반환
    // x는 [0 .. 5^n] 범위에서 생각 (x<=0 -> 0개, x>=5^n -> 전체 1의 개수)
    static long countPrefix(int n, long x) {
        if (x <= 0) return 0;
        if (n == 0) return x >= 1 ? 1 : 0;          // S_0 = "1"
        if (x >= pow5[n]) return ones[n];           // 전부 포함

        long unit = pow5[n - 1];                    // 하위 블록 길이
        long full = x / unit;                       // 전 블록 개수(0~4)
        long rem  = x % unit;                       // 다음 블록에서 남은 길이

        // S_n = [S_{n-1}, S_{n-1}, 0...0, S_{n-1}, S_{n-1}] (각 블록 길이 = unit)
        // 즉 블록 인덱스 0,1,3,4는 S_{n-1}, 2는 전부 0
        switch ((int) full) {
            case 0: // [0]의 일부
                return countPrefix(n - 1, rem);
            case 1: // [0] 전체 + [1] 일부
                return ones[n - 1] + countPrefix(n - 1, rem);
            case 2: // [0],[1] 전체 + [2] 일부(전부 0)
                return 2 * ones[n - 1];
            case 3: // [0],[1] 전체 + [2] 전체(0) + [3] 일부
                return 2 * ones[n - 1] + countPrefix(n - 1, rem);
            case 4: // [0],[1],[3] 전체 + [4] 일부
                return 3 * ones[n - 1] + countPrefix(n - 1, rem);
            default:
                // x < 5^n 이므로 여기 오지 않음
                return 0;
        }
    }

    public long solution(int n, long l, long r) {
        // 거듭제곱 사전 계산
        pow5[0] = 1;
        ones[0] = 1; // S_0 = "1" 이므로 1의 개수는 1
        for (int i = 1; i <= n; i++) {
            pow5[i] = pow5[i - 1] * 5L;   // 5^i
            ones[i] = ones[i - 1] * 4L;   // 4^i (S_i 전체 1의 개수)
        }

        // [l, r] (1-based, 폐구간) = prefix(r) - prefix(l-1)
        return countPrefix(n, r) - countPrefix(n, l - 1);
    }

    // 간단 테스트
    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        System.out.println(s.solution(2, 4, 17)); // expected 8
    }
}
