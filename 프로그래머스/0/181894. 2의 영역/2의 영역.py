def solution(arr):
    answer = []
    bucket = []
    
    for i in range(len(arr)) :
        if arr[i] == 2 :
            bucket.append(i)
            
    if not bucket :
        return [-1]
    if len(bucket) == 1 :
        return [2]
    
    for i in range(bucket[0], bucket[-1]+1) :
        answer.append(arr[i])
    
    return answer