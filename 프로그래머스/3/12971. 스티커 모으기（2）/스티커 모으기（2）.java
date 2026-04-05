import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        if(sticker.length == 1) {
            return sticker[0];
        } else if (sticker.length == 2) {
            Math.max(sticker[0], sticker[1]);
        }
        
        int[] arr1 = new int[sticker.length];
        int[] arr2 = new int[sticker.length];
        
        arr1[0] = arr1[1] = sticker[0];
        arr2[1] = sticker[1];
        
        for(int i=2; i<sticker.length; i++) {
            if(i < sticker.length-1) arr1[i] = Math.max(sticker[i] + arr1[i-2], arr1[i-1]);
            arr2[i] = Math.max(sticker[i] + arr2[i-2], arr2[i-1]);
        }

        return Math.max(arr1[arr1.length-2], arr2[arr1.length-1]);
    }
}