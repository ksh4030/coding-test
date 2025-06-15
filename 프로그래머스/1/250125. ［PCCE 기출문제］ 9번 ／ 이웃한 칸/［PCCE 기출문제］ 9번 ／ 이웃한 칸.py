def solution(board, h, w):
    answer = 0
    
    dr = [-1, 0, 1, 0]
    dc = [0, 1, 0, -1]
    
    for i in range(4) :
        r = dr[i] + h
        c = dc[i] + w
        
        if r<0 or c<0 or r>=len(board) or c>=len(board[0]) :
            continue
        
        if board[r][c] == board[h][w] :
            answer += 1
    
    return answer