class TestClass:
    def setName(self, firstName, lastName):
        self.firstName = firstName
        self.lastName = lastName

    def printFullName(self):
        print(self.firstName," ", self.lastName)
    

testClass = TestClass();
testClass.setName("Praveen", "Rajan")
testClass.printFullName()
