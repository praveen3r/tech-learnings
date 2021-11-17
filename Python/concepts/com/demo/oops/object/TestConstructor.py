class TestConstructor:
    def __init__(self, arg1, arg2="Default"):
        self.arg1 = arg1
        self.arg2 = arg2


obj1 = TestConstructor("testObj10", "testObj11")
obj2 = TestConstructor("testObj20")

print(obj1.arg2)
print(obj2.arg2)
