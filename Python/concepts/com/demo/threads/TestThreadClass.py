import threading

class MyThread(threading.Thread):
    def __init__(self, num):
        threading.Thread.__init__(self)
        self.num = num
    
    def run(self):
        print("Start thread")
        print(self.num  + 3)
        print("End thread")
    
thread1 = MyThread(2);
thread2 = MyThread(5);

thread1.start()
thread2.start()

print(thread1.getName())
print("No of active thread",threading.active_count())
print("current thread",threading.current_thread())
print("Enumerate thread",threading.enumerate())

thread1.join()
thread2.join()
