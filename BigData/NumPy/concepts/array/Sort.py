import numpy as np

a = np.array([21, 6, 13, 1])
result = np.sort(a)

print(result)

b = np.array([[3, 1, 5],
                   [9, 6, 2]])

result = np.sort(b, axis=0)

print(result)

c = np.array([[3, 1, 5],
                   [9, 6, 2]])

result = np.sort(c, axis=1)

print(result)

d = np.array([
    [[3, 1], [5, 4]],
    [[9, 7], [6, 2]]
])

result = np.sort(d, axis=-0)
print(result)

e = np.array([
    [[3, 1], [5, 4]],
    [[9, 7], [6, 2]]
])

result = np.sort(e, axis=-1)
print(result)

