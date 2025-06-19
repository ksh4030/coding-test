def solution(A, B):
    answer = 0
    
    for i in range(len(B)) :
        if(A == B) :
            return answer
        A = A[len(B)-1:] + A[:len(B)-1]
        answer += 1
    
    return -1