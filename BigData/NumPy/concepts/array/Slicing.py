import numpy as np

#single dimensional
b = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9])

print("Values:", b[1:3])
print("Values1:", b[2:5])
print("Values2:", b[5:]) #end:index
print("Values2:", b[:5]) #start:index
print("Values1:", b[1:7:2]) #start:end:step


#array[row_start:row_end, col_start:col_end]
c = np.array([
    [10, 20, 30],
    [40, 50, 60],
    [70, 80, 90]
])

print("Values1:",c[0:2, :]) #start:end:step , get first 2 rows
print("Values1:",c[:, 0:2]) #get first 2 columns
print("Values1:",c[1:, 1:]) #Get bottom-right 2×2 block
print("Values1:",c[0, :]) #Get first row 
print("Values1:",c[1, 1:2]) #columns 1 to 2 (not including 2) from the second row 
