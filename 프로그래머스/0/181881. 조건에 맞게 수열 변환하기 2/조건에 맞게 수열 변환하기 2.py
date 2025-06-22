import copy
def solution(arr):
    answer = 0
    nArr = copy.deepcopy(arr)
    cal(nArr)
    
    while arr != nArr :
        tmp = copy.deepcopy(arr)
        arr = copy.deepcopy(nArr)
        cal(nArr)
        answer += 1
    
    return answer

def cal(arr) :
    for i in range(len(arr)) :
        if arr[i] >= 50 and arr[i] % 2 == 0 :
            arr[i] //= 2
        elif arr[i] < 50 and arr[i] % 2 != 0 :
            arr[i] = arr[i] * 2 + 1
            