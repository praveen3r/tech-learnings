from abc import ABC, abstractmethod

# Abstract class
class Employee(ABC):
    def __init__(self, name, employee_id):
        self.name = name
        self.employee_id = employee_id

    @abstractmethod
    def calculate_salary(self):
        """Abstract method to calculate salary"""
        pass

    @abstractmethod
    def get_employee_details(self):
        """Abstract method to get employee details"""
        pass