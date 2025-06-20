def solution(numbers):
    digit = {
         "zero" : "0", 
        "one" : "1", 
        "two" : "2", 
        "three" : "3", 
        "four" : "4", 
        "five" : "5", 
        "six" : "6", 
        "seven" : "7", 
        "eight" : "8", 
        "nine" : "9"
    }
    
    for s, n in digit.items() :
        numbers = numbers.replace(s, n)
    answer = int(numbers)
    return answer