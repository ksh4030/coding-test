def solution(arr, queries):
    answer = []
    
    for a in queries :
        n = 1000001
        for i in range(a[0], a[1] + 1) :
            if arr[i] > a[2] :
                n = min(n, arr[i])
        if n == 1000001 :
            answer.append(-1)
        else :
            answer.append(n)
    
    return answer