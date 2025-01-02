def outerFunction(text):
    def innerFunction():
        print(text)
    return innerFunction

a = outerFunction('Hello')
del outerFunction
a()
    
        