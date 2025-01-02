from time import time

def decorator_func(func):
    def wrapper_func():
        start = time()
        print('start time is ',start)
        func()
        end = time()
        print('end time is ',end)
        elapsedTime = end - start
        print('elapsedTime is ', elapsedTime)
    return wrapper_func


@decorator_func
def say_hello():
    print('Hello')

say_hello()