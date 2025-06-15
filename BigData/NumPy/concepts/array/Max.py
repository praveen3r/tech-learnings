import numpy as np

a = np.array([10, 3, 7, 2, 9])

result = np.max(a)

print(result)   

b = np.array([[5, 8],
                   [3, 1]])

result = np.max(b) # Minimum of entire array
print(result) 

result = np.max(b, axis=0) # Minimum of each column
print(result)  

result = np.max(b, axis=1) # Minimum of each row
print(result)  # → [5 1]