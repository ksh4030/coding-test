def solution(data, ext, val_ext, sort_by):
    answer = []
    
    for i in range(len(data)) :    
        if ext == "code" :
            e = 0
        elif ext == "date" :
            e = 1
        elif ext == "maximum" :
            e = 2
        else :
            e = 3
            
        if sort_by == "code" :
            s = 0
        elif sort_by == "date" :
            s = 1
        elif sort_by == "maximum" :
            s = 2
        else :
            s = 3
    
    for i in range(len(data)) :
        if val_ext > data[i][e] :
            answer.append(data[i])
            
    answer.sort(key=lambda x:x[s])
    return answer