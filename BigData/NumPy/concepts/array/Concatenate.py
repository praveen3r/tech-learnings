import numpy as np

a = np.array([10, 20])
b = np.array([11, 21])

ab = np.concatenate((a, b))
print(ab)

c = np.array([[1, 2], [3, 4]])
d = np.array([[5, 6], [7, 8]])

cd = np.concatenate((c, d), axis=0)
print(cd)

cd1 = np.concatenate((c, d), axis=1)
print(cd1)

e = np.array([[[1], [2]], [[3], [4]]])
f = np.array([[[5], [6]], [[7], [8]]])

ef = np.concatenate((e, f), axis=0)
print(cd)

ef1 = np.concatenate((e, f), axis=1)
print(ef1)
