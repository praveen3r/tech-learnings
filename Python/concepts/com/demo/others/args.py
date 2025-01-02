import argparse

if __name__ == '__main__':

    parser = argparse.ArgumentParser("Enter two numbers")

    parser.add_argument('num1', help='Number 1', type=float)
    parser.add_argument('num2', help='Number 2', type=float)

    args = parser.parse_args()

    result = None

    print(args)

    result = args.num1 + args.num2

    print(result)

# hw to run:  & C:/Users/prave/AppData/Local/Programs/Python/Python313/python.exe c:/Workspace/Learn/projects/Python/concepts/com/demo/others/args.py 55 59
