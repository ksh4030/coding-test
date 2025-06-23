def solution(strArr):
    answer = 0
    arr = []
    m = 0
    
    for s in strArr :
        m = max(len(s), m)
    
    for i in range(m+1) :
        arr.append(0)
    
    for s in strArr :
        arr[len(s)] += 1
    
    return max(arr)