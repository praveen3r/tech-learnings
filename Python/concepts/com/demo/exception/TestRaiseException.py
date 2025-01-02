class CoffeeCup:

    def checkTemp(self,temp):
        if temp > 85:
            raise Exception("too hot")
        elif temp > 75:
            raise ValueError("not cold")
        else:
            print("right temperature")


try:
    coffeeCup = CoffeeCup()
    coffeeCup.checkTemp(85)
except ValueError as e:
    print("ValueError is ", e)
except Exception as e:
    print("Exception is ", e)