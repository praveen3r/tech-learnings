class Salary:
    def __init__(self, base_pay, bonus):
        self.base_pay = base_pay
        self.bonus = bonus

    def calculate_total_salary(self):
        return self.base_pay + self.bonus