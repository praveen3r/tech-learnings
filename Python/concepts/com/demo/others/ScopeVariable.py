x = 'global'

def display():
    global x
    print('1-->',x)
    x = 'local'
    print('2-->',x)

display()
print('3-->',x)