import numpy as np

# Random integers from 0 to 9 (inclusive of 0, exclusive of 10)
result = np.random.randint(0, 10, size=5)
print(result)

# Random float
result = np.random.rand(3)
print(result)

# Random float 2D
result = np.random.rand(2, 3)
print(result)

# Mean = 0, Std Dev = 1
result = np.random.randn(4)
print(result)

# random choices
choices = np.array([10, 20, 30, 40])
result = np.random.choice(choices, size=3)
print(result)

# shuffle
result = np.array([1, 2, 3, 4, 5])
np.random.shuffle(result)
print(result)

#seed (same random no)
np.random.seed(42)
result = np.random.randint(0, 100, size=5)
print(result)