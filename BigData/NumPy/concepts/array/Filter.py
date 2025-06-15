import numpy as np

arr = np.array([10, 20, 30, 40, 50])

filtered = arr[arr > 25]
print(filtered)

#-----------------------------------------------------

# multiple conditions

arr = np.array([10, 20, 30, 40, 50])

filtered = arr[(arr > 20) & (arr < 45)]
print(filtered)

#-----------------------------------------------------

# 2D

arr = np.array([[1, 2], [3, 4], [5, 6]])

filtered = arr[arr > 3]
print(filtered)

#-----------------------------------------------------

# 2D

arr = np.array([10, 20, 30, 40, 50])
mask = np.array([True, False, True, False, True])
print(arr[mask])