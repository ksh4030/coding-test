def solution(numer1, denom1, numer2, denom2):
    answer = []
    
    n = lcm(denom1, denom2)
    a1 = n // denom1
    a2 = n // denom2
    a = (numer1 * a1) + (numer2 * a2)
    g = gcd(a, n)
    return [a//g,n//g]

def gcd(a, b) :
    while b != 0 :
        a, b = b, a%b
    return a

def lcm(a, b) :
    return a*b // gcd(a,b)