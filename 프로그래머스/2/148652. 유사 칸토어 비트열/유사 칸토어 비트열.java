class Solution {
    public int solution(int n, long l, long r) {
        return countOnes(n, l - 1, r - 1);
    }

    private int countOnes(int n, long l, long r) {
        if (n == 0) {
            return (l == 0 && r == 0) ? 1 : 0;
        }

        int count = 0;
        long length = (long) Math.pow(5, n - 1);  // n-1 단계에서의 비트열 길이

        for (long i = l; i <= r; i++) {
            long indexInPattern = (i / length) % 5;  // 현재 인덱스가 속한 구간을 찾는다.

            if (indexInPattern == 2) {
                // 5등분한 가운데 부분이면 0
                continue;
            } else {
                // 가운데가 아닌 부분이면 재귀적으로 값을 계산
                count += countOnes(n - 1, i % length, i % length);
            }
        }

        return count;
    }
}