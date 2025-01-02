try:
    # print(1/0) ZeroDivisionError
    # print(float("abc"))# TypeError
    print("check exceptiona")
# except Exception as e:
#    print("Error is ", e)
except ZeroDivisionError as e:
    print("ZeroDivisionError is ", e)
except ValueError as e:
    print("ValueError is ", e)
else:
    print("coming to else")
finally:
    print("will compulsory execute")

print("coming here")
