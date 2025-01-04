import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = A.length-1;
        for(int i=0; i<A.length; i++) {
            answer += A[i]*B[idx--];
        }

        return answer;
    }
}