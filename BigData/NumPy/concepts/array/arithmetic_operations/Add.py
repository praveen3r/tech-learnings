import numpy as np

a = np.array([10, 20, 30])
b = np.array([1, 2, 3])

result = np.add(a, b)
print(result)

c = np.array([[1, 2, 3],
                [4, 5, 6]])

result = np.sum(c)
print(result)

result = np.sum(c, axis=1)
print(result)

result = np.sum(c, axis=0)
print(result)