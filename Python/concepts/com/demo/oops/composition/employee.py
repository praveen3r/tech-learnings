from salary import Salary

class Employee:
    def __init__(self, name, position, base_pay, bonus):
        self.name = name
        self.position = position

        self.salary = Salary(base_pay,bonus );  # Salary object as a property of Employee

    def get_employee_details(self):
        return f"Name: {self.name}, Position: {self.position}, Total Salary: {self.salary.calculate_total_salary()}"
