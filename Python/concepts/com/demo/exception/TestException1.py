try:
    # print(1/0) ZeroDivisionError
    print(float("abc"))# TypeError
# except Exception as e:
#    print("Error is ", e)
except ZeroDivisionError as e:
    print("ZeroDivisionError is ", e)
except ValueError as e:
    print("ValueError is ", e)

print("coming here")
