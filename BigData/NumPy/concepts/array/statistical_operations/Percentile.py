import numpy as np

a = np.array([[1, 2, 3],
                [4, 5, 6],
                [7, 8, 9]])

result = np.percentile(a, 50)

print(result)