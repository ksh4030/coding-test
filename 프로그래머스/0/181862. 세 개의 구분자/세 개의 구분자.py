def solution(myStr):
    answer = []
    
    myStr = myStr.replace("a", " ")
    myStr = myStr.replace("b", " ")
    myStr = myStr.replace("c", " ")
    
    arr = myStr.split(" ")
    
    for s in arr :
        if s != "" :
            answer.append(s)
    
    if len(answer) == 0 :
        return ["EMPTY"]
    else :
        return answer