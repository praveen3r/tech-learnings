"""
In Python a function is defined using the def keyword:

"""


def display():
    print("Hello from a function")


# To call a function, use the function name followed by parenthesis:
display()

"""
Arguments

Information can be passed into functions as arguments.

Arguments are specified after the function name, inside the parentheses. 
You can add as many arguments as you want, just separate them with a comma.
"""


def function1(arg1):
    print(arg1)


function1("argument 1")

"""
Keyword Arguments

You can also send arguments with the key = value syntax.

This way the order of the arguments does not matter.
"""


def function2(arg3, arg2, arg1):
    print("arg3 is" + arg3)


function2(arg1="Emil", arg2="Tobias", arg3="Linus")

"""
Default Parameter Value

The following example shows how to use a default parameter value.

If we call the function without argument, it uses the default value:
"""


def function3(country="Norway"):
    print("I am from " + country)


function3("Sweden")
function3()
function3("Brazil")

"""
Passing a List as an Argument

You can send any data types of argument to a function (string, number, list, dictionary etc.), 
and it will be treated as the same data type inside the function.
"""


def function4(tech):
    for x in tech:
        print(x)


function4(["Java", "Python", "JS"])

"""
Return Values

To let a function return a value, use the return statement:
"""


def function5(x):
    return "return value passed from function " + x


print(function5("test1"))
print(function5("test2"))

"""
Deafult parameters Values

"""

def function6(x=20):
    print("the value of x is",x)


function6(22)
function6()

"""
one or more Values with astericks

"""

def function7(*marks):
    print(marks)


function7(22)
function7(22, 34, 43)
