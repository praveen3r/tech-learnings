import numpy as np

a = np.array([10, 20, 30, 40])

print("Item", a[0])
print("Item", a[2])
print("Item", a[-1]) #last value

b = np.array([[10, 20, 30],[11, 21, 31]])

print("Item1", b[0][0])
print("Item1", b[1][2])
print("Item1", b[0][2])
print("Item1", b[0][-1])

c = np.array([[[10, 20, 30],[11, 21, 31]],[[12, 22, 32],[13, 23, 33]]])

print("Item2", c[0][0][0]) #first 2darray, row and column inside that
print("Item2", c[1][1][2])
print("Item2", c[0][1][0])
print("Item1", c[0][1][-1])
