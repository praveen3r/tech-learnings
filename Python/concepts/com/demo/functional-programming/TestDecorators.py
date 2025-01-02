def decorator_func(func):
    def wrapper_func():
        print('Entering the method')
        func()
        print('Exiting the method')
    return wrapper_func



# def say_hello():
#     print('Hello')

# hello = decorator_func(say_hello)
# hello()


@decorator_func
def say_hello():
    print('Hello')

say_hello()