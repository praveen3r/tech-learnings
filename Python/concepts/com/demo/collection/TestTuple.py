"""
Tuple

A tuple is a collection which is ordered and unchangeable. In Python tuples are written with round brackets.
"""
x = (1, 2, 3)
print(x)

"""
Access Tuple Items

You can access tuple items by referring to the index number, inside square brackets:
"""
x = (1, 2, 3)
print(x[1])

"""
Negative Indexing

Negative indexing means beginning from the end, -1 refers to the last item, -2 refers to the second
last item etc.

"""
x = (1, 2, 3)
print(x[-1])

"""
Range of Indexes

You can specify a range of indexes by specifying where to start and where to end the range.

When specifying a range, the return value will be a new tuple with the specified items.
"""
x = (1, 2, 3)
print(x[0:2])

"""
Loop Through a Tuple

You can loop through the tuple items by using a for loop.
"""
x = (1, 2, 3)
for value in x:
    print(value)

"""
Check if Item Exists

To determine if a specified item is present in a tuple use the in keyword:
"""
x = (1, 2, 3)
if 1 in x:
    print("ha ha ha")

"""
Tuple Length

To determine how many items a tuple has, use the len() method:
"""
x = (1, 2, 3)
print(len(x))

"""
Create Tuple With One Item

To create a tuple with only one item, you have to add a comma after the item,
otherwise Python will not recognize it as a tuple.
"""
x = (1, )
print(type(x))

"""
Join Two Tuples

To join two or more tuples you can use the + operator:
"""
tuple1 = ("a", "b" , "c")
tuple2 = (1, 2, 3)

tuple3 = tuple1 + tuple2
print(tuple3)

"""
The tuple() Constructor

It is also possible to use the tuple() constructor to make a tuple.
"""
x = tuple(("apple", "banana", "cherry")) # note the double round-brackets
print(x)
