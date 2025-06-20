def solution(picture, k):
    answer = []
    
    for s in picture :
        a = ''
        for c in s :
            for i in range(k) :
                a += c
        
        for i in range(k) :
            answer.append(a)
    
    return answer