# def double(x):
#     return x * 2
# def add(x, y):
#     return x + y
# def product(x, y, z):
#     return x * y * z

from functools import reduce

double = lambda x : x * 2

add = lambda x, y : x + y

product = lambda x, y, z : x * y * z

print(double(4))
print(add(4, 5))
print(product(4, 5, 6))

testList = [1, 2, 3, 4,4 , 5, 8, 23]

a = map(lambda x : x * 2, testList)

print(list(a))

testList1 = [2, 3, 3, 4,6 , 6, 8, 11]

b = map(lambda x, y : x + y, testList, testList1)

print(list(b))

c = filter(lambda x: x%2 == 0, testList)

print(list(c))

d = filter(lambda x: True if x>5 else False, testList)

print(list(d))

e = reduce(lambda x, y: x+y, testList)


print(e)