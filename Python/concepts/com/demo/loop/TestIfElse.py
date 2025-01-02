# IF statement
a = 33
b = 200
if b > a:
    print("b is greater than a")

"""
Indentation

Python relies on indentation (whitespace at the beginning of a line) to define scope in the code. 
Other programming languages often use curly-brackets for this purpose.
"""

# Elif

a = 33
b = 33
if b > a:
    print("b is greater than a")
elif a == b:
    print("a and b are equal")

# Else

a = 200
b = 33
if b > a:
    print("b is greater than a")
elif a == b:
    print("a and b are equal")
else:
    print("a is greater than b")

x = 100
if x > 100:
    print("x is greater than 100")
elif x < 100:
    print(" x is less than 100")
else:
    print("ha ha ha")

"""
Short Hand If

If you have only one statement to execute, you can put it on the same line as the if statement.
"""

if a > b: print("a is greater than b")

"""
nested if
"""
name = "animal"
name1 = "dog"
if name=="animal":
    if name1=="dog":
        print("Dog is an animal")
    print("it is animal")
else:
    print("it is not animal")

