def solution(before, after):
    answer = 0
    v = [False] * len(before)
    
    for i in range(len(before)) :
        for j in range(len(after)) :
            if before[i] == after[j] and v[j] == False :
                v[j] = True
                break
                
    if False in v :
        answer = 0
    else :
        answer = 1
    
    return answer