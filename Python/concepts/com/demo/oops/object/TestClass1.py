class TestClass1:
    pass


obj1 = TestClass1()
obj2 = TestClass1()

obj1.property1 = "value1"
obj1.property2 = "value2"

obj2.property1 = "Diff value1"
obj2.property2 = "Diff value2"

print(obj1)
print(obj1.property1)
print(obj2)
print(obj2.property1)
