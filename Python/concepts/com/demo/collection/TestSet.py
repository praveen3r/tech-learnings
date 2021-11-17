"""
Set

A set is a collection which is unordered and unindexed. In Python sets are written with curly brackets.
"""
x = {1, 2, 3, 4}
print(x)

"""
Access Items

You cannot access items in a set by referring to an index, since sets are unordered the items has no index.

But you can loop through the set items using a for loop, or ask if a specified value is present in a set, 
by using the in keyword.
"""
x = {1, 2, 3, 4}
for value in x:
    print(value)

"""
Add Items

To add one item to a set use the add() method.

To add more than one item to a set use the update() method.
"""
x = {1, 2, 3, 4}
x.add(10)
print(x)

# Add multiple items to a set, using the update() method:
x = {1, 2, 3, 4}
x.update([5, 6, 7])
print(x)

"""
Get the Length of a Set

To determine how many items a set has, use the len() method.
"""
x = {1, 2, 3, 4}
print(len(x))

"""
Remove Item

To remove an item in a set, use the remove(), or the discard() method.
"""
x = {1, 2, 3, 4}
x.remove(2)
print(x)

# Remove using the discard() method (will not throw error if value not present)
x = {1, 2, 3, 4}
x.discard(2)
print(x)

"""
You can also use the pop(), method to remove an item, but this method will remove the last item. 

Remember that sets are unordered, so you will not know what item that gets removed.
"""
x = {1, 2, 3, 4}
x.pop()
print(x)

# The clear() method empties the set:
x = {1, 2, 3, 4}
x.clear()
print(x)

# The del keyword will delete the set completely:
x = {1, 2, 3, 4}
del x
# print(x)

"""
Join Two Sets

There are several ways to join two or more sets in Python.

You can use the union() method that returns a new set containing all items from both sets,
or the update() method that inserts all the items from one set into another:
"""
x = {1, 2, 3, 4}
y = {5, 6, 7, 4}
z = x.union(y)
print(z)

# The update() method inserts the items in set2 into set1:
x = {1, 2, 3, 4}
y = {5, 6, 7, 4}
x.update(y)
print(x)
"""
The set() Constructor

It is also possible to use the set() constructor to make a set.
"""
x = set((1, 2, 3, 4))
print(x)

"""
difference() Method

return a set that contains the items that only exist in set x, and not in set y:
"""
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}

z = x.difference(y)

print(z)

"""
difference_update

Remove the items that exist in both sets:
"""
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}

x.difference_update(y)
print(x)

"""
intersection

Return a set that contains the items that exist in both set x, and set y::
"""
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}

z = x.intersection(y)

print(z)

"""
symmetric_difference

Return a set that contains all items from both sets, except items that are present in both sets:
"""
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}

z = x.symmetric_difference(y)

print(z)

"""
symmetric_difference_update

Remove the items that are present in both sets, AND insert the items that is not present in both sets:
"""
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}

x.symmetric_difference_update(y)

print(x)