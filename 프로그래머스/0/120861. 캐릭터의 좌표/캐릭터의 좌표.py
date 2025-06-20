def solution(keyinput, board):
    answer = [0,0]
    
    board[0] = board[0] // 2
    board[1] = board[1] // 2
    
    print(board)
    
    for s in keyinput :
        if s == "left" :
            if board[0] * -1 < answer[0] :
                answer[0] -= 1
        elif s == "right" :
            if board[0] > answer[0] :
                answer[0] += 1
        elif s == "down" :
            if board[1]*-1 < answer[1] :
                answer[1] -= 1
        else :
            if board[1] > answer[1] :
                answer[1] += 1
        print(answer)
    
    return answer