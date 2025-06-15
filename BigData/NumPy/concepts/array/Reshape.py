import numpy as np

b = np.array([11,12,13,14])

c = np.reshape(b, (2,2));

print("Shape:", c)

d = b.reshape(2,-1) # fill columns dynamically

print("Shape:", c)

e= c.reshape(-1) # flatten 2D

print("Original:", e)

f = np.array([
    [11, 12],
    [13, 14],
    [15, 16]
])

g = f.reshape(2, 1, 3) # anything where a × b × c = 6
print("3D array:\n", g)

h = f.reshape(-1) # flatten it to 1D
print("Original array:\n", h)
