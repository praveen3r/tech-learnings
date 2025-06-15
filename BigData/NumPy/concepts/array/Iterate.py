import numpy as np

arr = np.array([10, 20, 30])

for value in arr:
    print(value)

#---------------------------------------------------------

arr1 = np.array([[11, 21], [31, 41]])

for row in arr1:
    print(row)
    for value in row:
        print(value)

# or

for value in arr1.flat:
    print(value)

#---------------------------------------------------------

arr2 = np.array([
    [[12, 22], [32, 42]],
    [[52, 62], [72, 82]]
])

for block in arr2:
    for row in block:
        for value in row:
            print(value)

# or

for value in arr2.flat:
    print(value)

#---------------------------------------------------------

#using nditer

import numpy as np

a = np.array([1, 2, 3])

for x in np.nditer(a):
    print(x)

#---------------------------------------------------------

a = np.array([[1, 2], [3, 4]])

for x in np.nditer(a):
    print(x)

#---------------------------------------------------------

#op_flags

a = np.array([[1, 2], [3, 4]])

for x in np.nditer(a, op_flags=['readwrite']):
    x[...] = x * 2

print(a)

#---------------------------------------------------------

# external_loop

a = np.array([[1, 2, 3], [4, 5, 6]])

for x in np.nditer(a, flags=['external_loop']):
    print(x)

#---------------------------------------------------------

# with indices

a = np.array([[10, 20], [30, 40]])

for idx, x in np.ndenumerate(a):
    print(f"Index: {idx}, Value: {x}")