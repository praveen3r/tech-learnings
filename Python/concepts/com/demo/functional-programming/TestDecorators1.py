def decorator_func(func):
    def wrapper_func():
        print('Entering the first method')
        func()
        print('Exiting the first method')
    return wrapper_func

def decorator_func1(func):
    def wrapper_func():
        print('Entering the second method')
        func()
        print('Exiting the second method')
    return wrapper_func


@decorator_func
@decorator_func1
def say_hello():
    print('Hello')

say_hello()