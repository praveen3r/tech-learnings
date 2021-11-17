package com.demo.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DetectDeadlock {

	public static void main(String[] args) {
		detectDeadLocks();
	}
	
	public static void detectDeadLocks() {
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		long[] threadIds = threadMXBean.findDeadlockedThreads();
		boolean isDeadLock = threadIds != null && threadIds.length > 0;
		System.out.println("Deadlock found "+ isDeadLock + " and threadIds "+threadIds);
		if (isDeadLock) {
		  ThreadInfo[] infos = threadMXBean.getThreadInfo(threadIds, true, true);
		  System.out.println("The following threads are deadlocked:");
		  for (ThreadInfo threadInfo1 : infos) {
			  System.out.println(threadInfo1.getThreadId());    //Prints the ID of deadlocked thread

	            System.out.println(threadInfo1.getThreadName());  //Prints the name of deadlocked thread

	            System.out.println(threadInfo1.getLockName());    //Prints the string representation of an object for which thread has entered into deadlock.

	            System.out.println(threadInfo1.getLockOwnerId());  //Prints the ID of thread which currently owns the object lock

	            System.out.println(threadInfo1.getLockOwnerName());  //Prints name of the thread which currently owns the object lock.
		  }
		}
		
	}

}
