import threading
import time

# Shared resource
counter = 0
# Lock object
lock = threading.Lock()

def increment_counter(thread_name):
    global counter
    for _ in range(5):
        print(f"{thread_name} attempting to acquire lock...")
        with lock:  # Automatically acquires and releases the lock
            print(f"{thread_name} has acquired the lock.")
            temp = counter
            time.sleep(1)  
            counter = temp + 1
            print(f"{thread_name} incremented counter to {counter}")
        print(f"{thread_name} has released the lock.")

# Create threads
thread1 = threading.Thread(target=increment_counter, args=("Thread-1",))
thread2 = threading.Thread(target=increment_counter, args=("Thread-2",))

# Start threads
thread1.start()
thread2.start()

# Wait for threads to finish
thread1.join()
thread2.join()