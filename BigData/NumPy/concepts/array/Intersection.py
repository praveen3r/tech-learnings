import numpy as np
from collections import Counter

a = np.array([1, 2, 3, 4])
b = np.array([3, 4, 5, 6])

result = np.intersect1d(a, b)
print(result)

#--------------------------------------------------------

# with duplicates

a = np.array([1, 2, 2, 3])
b = np.array([2, 2, 4])

result = np.intersect1d(a, b)
print(result)

#--------------------------------------------------------

# If we want duplicates too


a = [1, 2, 2, 3]
b = [2, 2, 4]

counter = Counter(a) & Counter(b)
result = list(counter.elements())
print(result)

#--------------------------------------------------------

# with different elements

a = np.array([1, 2, 2, 3])
b = np.array([4, 5, 6])

result = np.intersect1d(a, b)
print(result)

#--------------------------------------------------------

# 2D

a = np.array([[1, 2],
              [3, 4],
              [5, 6]])

b = np.array([[3, 4],
              [7, 8],
              [1, 2]])



# Convert each row to a single structured item
a_view = a.view([('', a.dtype)] * a.shape[1])
b_view = b.view([('', b.dtype)] * b.shape[1])

# Intersect those "rows"
intersected = np.intersect1d(a_view, b_view)

# Convert back to regular 2D array
result = intersected.view(a.dtype).reshape(-1, a.shape[1])
print(result)