import numpy as np

a = np.array([[1, 2, 3],
                [4, 5, 6],
                [7, 8, 9]])

result = np.mean(a)

print(result)

result = np.mean(a, axis=0)

print(result)

result = np.mean(a, axis=1)

print(result)
