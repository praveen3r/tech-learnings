import numpy as np

a = np.array([1, 2, 3])
b = np.array([4, 5, 6])

ab = np.stack((a, b), axis=0)
print(ab)

ab1 = np.stack((a, b), axis=1)
print(ab1)

c = np.array([[1, 2], [3, 4]])
d = np.array([[5, 6], [7, 8]])

cd = np.stack((c, d), axis=0)
print(cd)

cd1 = np.stack((c, d), axis=1)
print(cd1)

e = np.array([[[1], [2]], [[3], [4]]])
f = np.array([[[5], [6]], [[7], [8]]])

ef = np.stack((e, f), axis=0)
print(ef)

ef1 = np.stack((e, f), axis=1)
print(ef1)
