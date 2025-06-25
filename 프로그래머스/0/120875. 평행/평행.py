def solution(dots):
    return int(isPossible(dots,0,1,2,3) or isPossible(dots,0,2,1,3) or isPossible(dots,0,3,1,2))

def isPossible(dots,a,b,c,d) :
    return abs(dots[a][1] - dots[b][1]) / abs(dots[a][0] - dots[b][0]) == abs(dots[c][1] - dots[d][1]) / abs(dots[c][0] - dots[d][0])