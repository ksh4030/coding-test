import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        int[][] board = new int[friends.length][friends.length];
        int[] score = new int[friends.length];
        int[] ans = new int[friends.length];
        
        for(int i=0; i<friends.length; i++) map.put(friends[i], i);        
        for(int i=0; i<gifts.length; i++) {
            String[] bucket = gifts[i].split(" ");
            board[map.get(bucket[0])][map.get(bucket[1])] += 1;
        }
        
        for(int i=0; i<friends.length; i++) {
            int r = 0;
            int c = 0;
            for(int j=0; j<friends.length; j++) {
                r += board[i][j];
                c += board[j][i];
            }            
            score[i] = r-c;
        }
        
        for(int i=0; i<friends.length; i++) {
            for(int j=i+1; j<friends.length; j++) {
                if(board[i][j] > board[j][i]){
                    ans[i]++;
                } else if(board[i][j] < board[j][i]) {
                    ans[j]++;
                } else {
                    if(score[i] > score[j]) {
                        ans[i]++;
                    } else if(score[i] < score[j]) {
                        ans[j]++;
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(board));
        // System.out.println(Arrays.toString(ans));
        answer = Arrays.stream(ans).max().orElseThrow();
        return answer;
    }
}