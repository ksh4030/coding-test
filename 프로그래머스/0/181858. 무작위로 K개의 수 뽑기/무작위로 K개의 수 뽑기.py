def solution(arr, k):
    answer = []
    
    for num in arr :
        if num not in answer :
            answer.append(num)
        
        if len(answer) == k :
            break
    
    while len(answer) < k :
        answer.append(-1)
        
    
    return answer