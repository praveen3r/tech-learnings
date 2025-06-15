import numpy as np

a = np.array([1, 2, 3, 4])
b = np.array([3, 4, 5, 6])

result = np.setdiff1d(a, b)
print(result)

#--------------------------------------------------------

# with duplicates

a = np.array([1, 2, 2, 3])
b = np.array([2])

result = np.setdiff1d(a, b)
print(result)

#--------------------------------------------------------

#2D array

a = np.array([[1, 2],
              [3, 4],
              [5, 6]])

b = np.array([[3, 4],
              [7, 8]])

# View each row as a record
a_view = a.view([('', a.dtype)] * a.shape[1])
b_view = b.view([('', b.dtype)] * b.shape[1])

# Set difference
diff_view = np.setdiff1d(a_view, b_view)

# Convert back to regular 2D array
diff_rows = diff_view.view(a.dtype).reshape(-1, a.shape[1])
print(diff_rows)