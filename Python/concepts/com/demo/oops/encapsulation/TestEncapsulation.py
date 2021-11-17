class TestEncapsulation:
    def set_value1(self, value1):
        self.__value1 = value1

    def get_value(self):
        return self.__value1


obj1 = TestEncapsulation()
obj1.set_value1("val1")
obj1.__value1 = "val22"
print(obj1.get_value())
