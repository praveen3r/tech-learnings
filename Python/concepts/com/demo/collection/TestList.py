# A list is a collection which is ordered and changeable. In Python lists are written with square brackets

x = [1, 3, 5, 7]
print(x)

"""
Access Items

You access the list items by referring to the index number:

Negative indexing means beginning from the end, -1 refers to the last item, 
-2 refers to the second last item etc.

"""
x = [1, 3, 5, 7]
print(x[1])
print(x[-1])

"""
Range of Indexes

You can specify a range of indexes by specifying where to start and where to end the range.

When specifying a range, the return value will be a new list with the specified items.

"""
x = [1, 3, 5, 7]
print(x[1:3])

# By leaving out the start value, the range will start at the first item:
print(x[:3])

# By leaving out the end value, the range will go on to the end of the list:
print(x[1:])

# Range of Negative Indexes
print(x[-4:-1])

"""
Change Item Value

To change the value of a specific item, refer to the index number:
"""
x = [1, 3, 5, 7]
x[1] = 4
print(x)

# Loop Through a List

num = [1, 3, 5, 7]
for x in num:
    print(x)

# Check if Item Exists
x = [1, 3, 5, 7]
if 3 in x:
    print("ha ha ha")

# List Length

x = [1, 3, 5, 7]
print(len(x))

"""
Add Items

To add an item to the end of the list, use the append() method:
"""
x = [1, 3, 5, 7]
x.append(66)
print(x)

# To add an item at the specified index, use the insert() method:
x = [1, 3, 5, 7]
x.insert(2,66)
print(x)

"""
Remove Item
There are several methods to remove items from a list:
"""

# The remove() method removes the specified item:
x = [1, 3, 5, 7]
x.remove(3)
print(x)

# The pop() method removes the specified index, (or the last item if index is not specified):
x = [1, 3, 5, 7]
x.pop()
print(x)
x.pop(1)
print(x)

# The del keyword removes the specified index:
x = [1, 3, 5, 7]
del x[0]
print(x)

# The del keyword can also delete the list completely:
x = [1, 3, 5, 7]
del x
#print(x)

# The clear() method empties the list:
x = [1, 3, 5, 7]
x.clear()
print(x)

"""
Copy a List

You cannot copy a list simply by typing list2 = list1, because: list2 will only be a reference to list1, 
and changes made in list1 will automatically also be made in list2.

There are ways to make a copy, one way is to use the built-in List method copy().
"""
x = [1, 3, 5, 7]
y = x.copy();
print(y)

"""
Join Two Lists

There are several ways to join, or concatenate, two or more lists in Python.

One of the easiest ways are by using the + operator.
"""
x = [1, 3, 5, 7]
y = [3, 3, 3, 1];
print(x + y)

#  you can use the extend() method, which purpose is to add elements from one list to another list:

x = [1, 3, 5, 7]
y = [3, 3, 3, 1];
x.extend(y)
print(x)

"""
The list() Constructor

It is also possible to use the list() constructor to make a new list.
"""
x = list((1, 3, 5, 7))
print(x)

# Sort

x = list((1, 8, 5, 7))
x.sort()
print(x)

# Reverse Sort

x = list((1, 8, 5, 7))
x.sort(reverse=True)
print(x)

# Reverse

x = list((1, 8, 5, 7))
x.reverse()
print(x)