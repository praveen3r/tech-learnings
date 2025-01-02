# Example Usage
from employee import Employee
from salary import Salary


employee_salary = Salary(base_pay=50000, bonus=10000)
employee = Employee(name="John Doe", position="Software Engineer", salary=employee_salary)

print(employee.get_employee_details())
