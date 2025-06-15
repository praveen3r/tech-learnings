import numpy as np

original = np.array([1, 2, 3, 4, 5])

# Create a view (shares data)
view = original.view()
# Create a copy (independent)
copy = original.copy()

# Modify the original
original[0] = 99

print("Original:", original)   # → [99  2  3  4  5]
print("View:    ", view)       # → [99  2  3  4  5] ← affected
print("Copy:    ", copy)       # → [ 1  2  3  4  5] ← NOT affected