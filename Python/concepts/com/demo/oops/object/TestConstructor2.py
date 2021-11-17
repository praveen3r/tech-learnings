class TestConstructor2:
    def __init__(self, *args):
        if len(args) > 0:
            self.values = [x for x in args]
        else:
            self.values = None


obj1 = TestConstructor2()
obj2 = TestConstructor2(1, 2, 3)
print(obj1.values)
print(obj2.values)
