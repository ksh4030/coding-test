def solution(data, ext, val_ext, sort_by):
    a = []
    target_num = 0
    
    if ext == "code" :
        target_num = 0
    elif ext == "date" :
        target_num = 1
    elif ext == "maximum" :
        target_num = 2
    elif ext == "remain" :
        target_num = 3
        
    for arr in data :
        if arr[target_num] < val_ext :
            a.append(arr)
    
    if sort_by == "code" :
        target_num = 0
    elif sort_by == "date" :
        target_num = 1
    elif sort_by == "maximum" :
        target_num = 2
    elif sort_by == "remain" :
        target_num = 3
        
    arr = [0]*len(a)
    answer = [[]]*len(a)
    
    for i in a :
        cnt = 0
        for j in a :
            if i == j :
                continue
            if i[target_num] > j[target_num] :
                cnt += 1
        answer[cnt] = i
                
    
    return answer