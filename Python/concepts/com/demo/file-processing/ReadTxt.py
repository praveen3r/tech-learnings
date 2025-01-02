fh = open("demo.txt") # default is read mode

# print(fh.read())

# print(fh.read(7)) read first 7 characters

print(fh.readline()) # read first line

print(fh.readlines(4)) # returns list of lines

for line in fh:
    print(line)

fh.close()

with open("demo.txt", "r") as file:
    for line in file:
        print(line.strip())