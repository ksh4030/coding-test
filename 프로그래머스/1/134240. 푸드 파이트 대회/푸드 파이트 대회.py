def solution(food):
    answer = ''
    
    for i in range(1, len(food)) :
        n = food[i] // 2
        for j in range(n) :
            answer += str(i)
    
    arr = sorted(answer, reverse = True)
    
    answer += '0'
    
    for n in arr :
        answer += str(n)
    
    return answer