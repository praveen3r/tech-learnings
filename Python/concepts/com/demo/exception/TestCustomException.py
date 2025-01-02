class CoffeeTooHotException(Exception):
    def __init__(self, *args):
        super().__init__(*args)

class CoffeeCup:

    def checkTemp(self,temp):
        if temp > 85:
            raise Exception("too hot")
        elif temp > 75:
            raise CoffeeTooHotException("not cold")
        else:
            print("right temperature")


try:
    coffeeCup = CoffeeCup()
    coffeeCup.checkTemp(85)
except CoffeeTooHotException as e:
    print("CoffeeTooHotException is ", e)
except Exception as e:
    print("Exception is ", e)