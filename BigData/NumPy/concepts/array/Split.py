import numpy as np

a = np.array([1, 2, 3, 4, 5, 6])

result = np.split(a, 3)

for p in result:
    print(p)

#------------------------------------------------------

# uneven split

aa = np.array([1, 2, 3, 4, 5])

result = np.split(a, 3)

print(result)

#------------------------------------------------------

# 2D array

b = np.array([[1, 2, 3],
              
                [4, 5, 6]])

result = np.split(b, 3, axis=1)

print(result)

#------------------------------------------------------

# hplit array

b = np.array([[1, 2, 3],
              
                [4, 5, 6]])

result = np.hsplit(b, 3)

print(result)

#------------------------------------------------------

# vsplit array

b = np.array([[1, 2, 3],
              
                [4, 5, 6]])

result = np.vsplit(b, 2)

print(result)