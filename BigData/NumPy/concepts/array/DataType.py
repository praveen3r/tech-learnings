import numpy as np

a = np.array([1, 2, 3])

print("Datatype:", a.dtype)

b = np.array(["aa", "bb", "cc"])

print("Datatype:", b.dtype)

# set datatype
c = np.array([1, 2, 3], dtype=np.float32)

print(c)
print(c.dtype)

# convert datatype
d = np.array([1, 2, 3])
e = d.astype(np.float64)

print(e)
print(e.dtype)