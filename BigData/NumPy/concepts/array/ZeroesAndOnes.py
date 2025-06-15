#Zeroes ----------------------------------------------------

import numpy as np

zeros_1d = np.zeros(5)             
zeros_2d = np.zeros((2, 3)) 
print(zeros_1d)
print(zeros_2d)

#------------------------------------------------------------

ones_1d = np.ones(4)               
ones_2d = np.ones((3, 2)) 
print(ones_1d)
print(ones_2d)

#-----------identity-------------------------------------------------

identity = np.eye(3)
print(identity)

#-----------non-identity-------------------------------------------------

non_identity = np.eye(2, 4)
print(non_identity)

#-----------set optional datatype-------------------------------------------------

np.zeros((2, 2), dtype=int)
np.ones((3, 3), dtype=bool)