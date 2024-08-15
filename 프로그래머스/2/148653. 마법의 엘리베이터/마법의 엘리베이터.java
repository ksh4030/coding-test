import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        int[] arr = new int[Integer.toString(storey).length()];
        
        for(int i=0; i<arr.length; i++) {
            arr[i] = storey%10;
            storey /= 10;
        }
        
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] == 10) {
                arr[i+1]++;
            }else if(arr[i] < 5) {
                answer += arr[i];
            } else if (arr[i] > 5) {
                answer += (10 - arr[i]);
                arr[i+1]++;
            } else {
                if(arr[i+1] >= 10) {
                    answer += 5;
                } else if(arr[i+1] >= 5) {
                    answer += 5;
                    arr[i+1]++;
                } else {
                    answer += arr[i];                    
                }
            }
        }
        
        if(arr[arr.length-1] == 10) {
            answer++;
        } else if (arr[arr.length-1] >= 6) {
            answer += (10-arr[arr.length-1]+1);
        } else {
            answer += arr[arr.length-1];
        }
        return answer;
    }
}