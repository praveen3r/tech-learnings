class Parent1:
    value1 = "This is parent1 and value1"
    value2 = "This is parent1 and value2"

class Parent2:
    value1 = "This is parent2 and value1"
    value2 = "This is parent2 and value2"

class Child (Parent1, Parent2):
    pass

child = Child()
print(child.value1);
print(child.value2);