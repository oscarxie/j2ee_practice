package com.asm.hibernate.test;

import java.util.LinkedList;

public class WorkQueue {
	private final int nThreads;
	private final PoolWorker[] threads;
	private final LinkedList queue;

	public WorkQueue(int nThreads) {
		this.nThreads = nThreads;
		queue = new LinkedList();
		threads = new PoolWorker[nThreads];

		for (int i = 0; i < nThreads; i++) {
			threads[i] = new PoolWorker(i);
			threads[i].start();
		}
	}

	public void execute(Runnable r) {
		synchronized (queue) {
			queue.addLast(r);
			queue.notify();
		}
	}

	class PoolWorker extends Thread {
		int i;

		PoolWorker(int i) {
			super("worker:" + String.valueOf(i));
		}

		public void run() {
			Runnable r;

			while (true) {
				synchronized (queue) {
					if (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException ignored) {
						}
					}

					r = (Runnable) queue.removeFirst();
				}

				// If we don't catch RuntimeException,
				// the pool could leak threads
				try {
					r.run();
					System.out.println("using  Thread "
							+ Thread.currentThread().getName()
							+ " to run Thread " + r.getClass());
				} catch (RuntimeException e) {
					System.out.println(e);
				}
			}
		}
	}


	public static void main(String args[]) {
		WorkQueue wq = new WorkQueue(3);
		for (int i = 0; i < 10; i++) {
//
//			wq.execute(new Runnable() {
//				public void run() {
//
//					try {
//						Thread.sleep(1000);
//					} catch (Exception e) {
//					}
//					System.out.println("execute Thread: " + this.getClass());
//				}
//
//			});
			
			Client client = new Client(wq,i);
			Thread clientThread = new Thread(client);
			clientThread.start();
		}
		
	}
}

class Client implements Runnable {
	WorkQueue wq;
  int i;
	public Client(WorkQueue wq) {
		super();
		this.wq = wq;
	}
	public Client(WorkQueue wq,int i) {
		super();
		this.wq = wq;
		this.i = i;
	}

	@Override
	public void run() {
		wq.execute(new Runnable() {
			public void run() {
				if( i==0)
					
					HibernateCacheTest.deleteUser(1);
				else if ( i==1){
					HibernateCacheTest.addUser();
					HibernateCacheTest.getUser(1);
				}
				System.out.println("execute Thread: " + this.getClass());
			}

		});
	}

}

