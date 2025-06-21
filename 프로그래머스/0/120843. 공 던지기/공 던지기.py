def solution(numbers, k):
    answer = 0
    
    while k-1 > 0 :
        k -= 1
        answer += 2
        
        if(answer >= len(numbers)) :
            answer %= len(numbers)
        
        print(answer)
    
    return answer+1