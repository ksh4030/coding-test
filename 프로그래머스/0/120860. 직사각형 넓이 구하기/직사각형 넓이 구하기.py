import math
def solution(dots):
    answer = 0
    s = dots[0]
    
    for i in range(1, len(dots)) :
        if (dots[i][0] != s[0] and dots[i][1] != s[1]) :
            x = abs(dots[i][0] - s[0])
            y = abs(dots[i][1] - s[1])
    
    return x*y