from employee import Employee

# Concrete class inheriting from the abstract class
class FullTimeEmployee(Employee):
    def __init__(self, name, employee_id, monthly_salary):
        super().__init__(name, employee_id)
        self.monthly_salary = monthly_salary

    def calculate_salary(self):
        return self.monthly_salary

    def get_employee_details(self):
        return f"Full-Time Employee: {self.name}, ID: {self.employee_id}, Salary: {self.calculate_salary()}"
