import numpy as np

a = np.array([10, 25, 30, 15])
result = np.where(a > 20)

print(result)

result = np.where(a == 25)

print(result)

result = np.where(a == 23)

print(result)

#--------------------------------------------------------------

# Conditional assignment

result = np.where(a > 20, 1, 0)

print(result)

result = np.where(a > 100, 1, 0)

print(result)

#--------------------------------------------------------------

# 2D

c = np.array([[5, 12], [15, 7]])
result = np.where(c > 10)

print(result)
print(c[result] )