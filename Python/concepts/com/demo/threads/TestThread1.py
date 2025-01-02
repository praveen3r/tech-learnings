import threading
import time

def addTwo(num):
    print("Thread 1-----------", time.time())
    print(num + 2)

def addThree(num):
    print("Thread 2-----------", time.time())
    print(num + 3)
    
thread1 = threading.Thread(target=addTwo, args = (1,))
thread2 = threading.Thread(target=addThree,args = (2,))

# Start threads
print("Starting threads...")
thread1.start()
thread2.start()

# Wait for threads to complete
thread1.join()
thread2.join()

print("All threads finished!")