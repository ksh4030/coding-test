def solution(num_list):
    answer = []
    
    if num_list[len(num_list)-1] > num_list[len(num_list)-2] :
        num_list.append(num_list[len(num_list)-1] - num_list[len(num_list)-2])
    else :
        num_list.append(num_list[len(num_list)-1]*2)
    
    return num_list