import numpy as np

a = np.array([1, 2, 3])
b = np.array([4, 5, 6])

ab = np.hstack((a, b))
print(ab)

c = np.array([[1, 2], [3, 4]])
d = np.array([[5, 6], [7, 8]])

cd = np.hstack((c, d))
print(cd)

e = np.array([[[1], [2]], [[3], [4]]])
f = np.array([[[5], [6]], [[7], [8]]])

ef = np.hstack((e, f))
print(ef)