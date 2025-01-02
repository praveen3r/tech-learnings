import threading
import time

def myThreadFunc(nameOfThread, delay):
    count = 0
    while(count < 4):
        time.sleep(delay)
        count += 1
        print(nameOfThread, "-----------", time.time())
    
thread1 = threading.Thread(target=myThreadFunc, args = ("TestThread 1", 1))
thread2 = threading.Thread(target=myThreadFunc,args = ("TestThread 2", 1))

# Start threads
print("Starting threads...")
thread1.start()
thread2.start()

# Wait for threads to complete
thread1.join()
thread2.join()

print("All threads finished!")