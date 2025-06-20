def solution(score):
    answer = []
    a = []
    
    for arr in score :
        a.append((arr[0] + arr[1]) / 2)
        
    for i in range(len(a)) :
        cnt = 1
        for j in range(len(a)) :
            if i == j :
                continue
            if a[i] < a[j] :
                cnt+=1
        answer.append(cnt)
    
    return answer