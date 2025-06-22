def solution(n):
    answer = []
    
    for i in range(2, n//2+1) :
        if isPrime(i) :
            if n % i == 0 :
                answer.append(i)
                
    if not answer :
        answer.append(n)
    
    return answer


def isPrime(n) :
    for i in range(2, int(n**0.5) + 1) :
        if n % i == 0 :
            return False
    return True