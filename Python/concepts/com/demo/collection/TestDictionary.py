"""
Dictionary

A dictionary is a collection which is unordered, changeable and indexed.
In Python dictionaries are written with curly brackets, and they have keys and values.
"""
x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
print(x)

"""
Accessing Items

You can access the items of a dictionary by referring to its key name, inside square brackets:
"""
x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
print(x["model"])

"""
Change Values

You can change the value of a specific item by referring to its key name:
"""

x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
x["year"] = 2000;
print(x)

"""
Loop Through a Dictionary

You can loop through a dictionary by using a for loop.

When looping through a dictionary, the return value are the keys of the dictionary, but there are methods 
to return the values as well.
"""

x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
for obj in x:
    print(" Key is {} and value is {}".format(obj, x[obj]))

# You can also use the values() method to return values of a dictionary:
x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
for value in x.values():
    print(value)

# Loop through both keys and values, by using the items() method:
x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
for key,value in x.items():
    print(key,value)

"""
Check if Key Exists
To determine if a specified key is present in a dictionary use the in keyword:
"""
x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
if "model" in x:
  print("Yes, 'model' is one of the keys in the dictionary")

"""
Adding Items

Adding an item to the dictionary is done by using a new index key and assigning a value to it:

"""
x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
x["color"] = "red"
print(x)

"""
Removing Items

There are several methods to remove items from a dictionary:
"""
x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
x.pop("model")
print(x)

""" 
The popitem() method removes the last inserted item (in versions before 3.7, 
a random item is removed instead):
"""
x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
x.popitem()
print(x)

# The del keyword removes the item with the specified key name:
x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
del x["model"]
print(x)

# The del keyword can also delete the dictionary completely:
x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
del x
# print(x)

# The clear() method empties the dictionary:
x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
x.clear
print(x)

"""
Copy a Dictionary
You cannot copy a dictionary simply by typing dict2 = dict1, because: dict2 will only be a 
reference to dict1, and changes made in dict1 will automatically also be made in dict2.

There are ways to make a copy, one way is to use the built-in Dictionary method copy().
"""
x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
y = x.copy()
print(y)

# Another way to make a copy is to use the built-in function dict().
x = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
y = dict(x)
print(y)

"""
The dict() Constructor

It is also possible to use the dict() constructor to make a new dictionary:
"""
x = dict(brand="Ford", model="Mustang", year=1964)
# note that keywords are not string literals
# note the use of equals rather than colon for the assignment
print(x)

# A simple nested dictionary
students = {
    "student1": {"name": "Alice", "age": 20, "grade": "A"},
    "student2": {"name": "Bob", "age": 22, "grade": "B"},
    "student3": {"name": "Charlie", "age": 19, "grade": "C"},
}

# You can access elements in a nested dictionary using multiple keys:

# Access Bob's grade
print(students["student2"]["grade"])  # Output: B

# Access Alice's age
print(students["student1"]["age"])  # Output: 20

# You can modify values by referencing the specific keys:

students["student3"]["grade"] = "B+"
print(students["student3"])  # Output: {'name': 'Charlie', 'age': 19, 'grade': 'B+'}

# To add a new dictionary or key-value pair:

students["student4"] = {"name": "Diana", "age": 21, "grade": "A"}
print(students["student4"])  # Output: {'name': 'Diana', 'age': 21, 'grade': 'A'}

# Iterating Over a Nested Dictionary

# Loop through the outer dictionary
for student_id, details in students.items():
    print(f"{student_id}:")
    # Loop through the inner dictionary
    for key, value in details.items():
        print(f"  {key}: {value}")