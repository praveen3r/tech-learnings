def outerFunction(text):
    def innerFunction():
        print(text)
    innerFunction()

outerFunction('Hello')
    
        