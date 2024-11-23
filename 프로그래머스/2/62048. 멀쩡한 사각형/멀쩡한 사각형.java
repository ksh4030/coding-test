import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long total = (long) w * h; // 전체 사각형 개수
        long gcd = gcd(w, h);     // 최대공약수 계산
        long unusable = w + h - gcd; // 대각선이 지나가는 칸의 수
        return total - unusable; // 사용 가능한 사각형의 개수
    }
    
    // 최대공약수 계산 (유클리드 호제법)
    private long gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
