import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        Arrays.sort(mats);
        
        for(int n=mats.length-1; n>=0; n--) {
            
            for(int i=0; i<park.length; i++) {
                for(int j=0; j<park[0].length; j++) {
                    if(!park[i][j].equals("-1")) continue;
                    boolean flag = true;
                    
                    loop:
                    for(int l = i; l<i+mats[n]; l++) {
                        for(int m=j; m<j+mats[n]; m++) {
                            try{
                                if(!park[l][m].equals("-1")) {
                                    flag = false;
                                    break loop;
                                }
                            } catch (Exception e) {
                                flag = false;
                                break loop;
                            }
                        }
                    }
                    
                    if(flag) {
                        return mats[n];
                    }
                    
                }
            }
            
        }
        
        return answer;
    }
}