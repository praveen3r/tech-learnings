print(type(2))
print(type(2.0))
print(type('2.0'))
print(2 + 2)
print('2' + '2')
print(2 * 2)
print('2' * 2)

class Number:
    def __init__(self, num):
        self.num = num

    def __add__(self, Number):
         return Number(self.num + Number.num)

n1 = Number(1)
n2 = Number(2)

print(n1 + n2)

class A:
      pass

a = dir(A)