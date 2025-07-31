import java.util.*;
class Solution {
    public long solution(int w, int h) {
        return (long)w*h - (w+h - gcd(w,h));
    }
    
    public long gcd(long w, long h) {
        while(h != 0) {
            long tmp = w % h;
            w = h;
            h = tmp;
        }
        return w;
    }
}