class TestEncapsulation1:
    def public_method(self):
        print("public method")
        self.__private_method()

    def __private_method(self):
        print("private method")


obj = TestEncapsulation1()
obj.public_method()
# obj.__private_method()
