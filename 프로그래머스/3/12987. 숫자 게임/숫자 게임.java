import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a=0, b=0;
        for(int i=0; i<A.length; i++) {
            try{
                if(!(A[a]<B[b])) b++;
                else {
                    a++;
                    b++;
                    answer++;
                }
            } catch (Exception e) {
                break;
            }
        }
        
        return answer;
    }
}