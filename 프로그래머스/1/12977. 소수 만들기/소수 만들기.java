import java.util.*;
class Solution {
    static int ans=0;
    static int[] sel;
    public int solution(int[] nums) {
        int answer = 0;
        sel = new int[3];
        com(0,0,nums);
        return ans;
    }
    
    public static void com(int idx, int k, int[] nums) {
        if(sel.length == k) {
            if(isPrime(Arrays.stream(sel).sum())) ans++;
            return;
        }
        
        for(int i=idx; i<nums.length; i++) {
            sel[k] = nums[i];
            com(i+1, k+1, nums);
        }
    }
    
    public static boolean isPrime(int num) {
        if(num <= 1) return false;
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}