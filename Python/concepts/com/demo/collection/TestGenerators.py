def myFunc():
    yield 'a'
    yield 'b'
    yield 'c'

a = myFunc()
print(next(a))

def testFunc():
    n = 1
    print(n)
    yield n
    n+=1
    print(n)
    yield n
    n+=1
    print(n)
    yield n

b = testFunc()
print(next(b))
print(next(b))
print(next(b))

def testFunc1():
    for i in range(5):
        print(i)
        yield i

c = testFunc1()
print(next(c))
print(next(c))
print(next(c))
