def solution(spell, dic):
    answer = 2
    
    for s in dic :
        if all(c in s for c in spell) :
            return 1
    
    return answer