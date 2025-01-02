# Data to write to the file
text = "Hello world"
# Open a file in write mode ('w') or create it if it doesn't exist
with open("demo.txt", "w") as file:
#with open("C:\\demo.txt", "a") as file:
    file.write(text)
    for i in range(10):
        file.write("Line no is %d \n" % (i+1))

print("Done!")







