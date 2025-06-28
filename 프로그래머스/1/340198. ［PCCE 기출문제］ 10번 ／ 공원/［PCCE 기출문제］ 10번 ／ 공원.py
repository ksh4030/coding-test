def solution(mats, park):
    answer = -1
    
    for i in range(len(park)) :
        for j in range(len(park[i])) :
            if park[i][j] == "-1" :
                for n in mats :
                    if isPossible(i,j,n,park) :
                        answer = max(answer, n)
    
    return answer

def isPossible(r, c, size, park) :
    for i in range(size) :
        for j in range(size) :
            nr = r+i
            nc = c+j
            
            if nr>=len(park) or nc>=len(park[0]) or park[nr][nc] != "-1" :
                return False
    return True