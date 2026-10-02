/**
 * ProducerConsumer_Q20.java
 * 
 * This program demonstrates the producer-consumer problem solution
 * where a producer produces a value and a consumer consumes it
 * before the producer generates the next value.
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer_Q20 {
    public static void main(String[] args) {
        // Create a blocking queue with capacity of 1
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);
        
        // Create producer and consumer threads
        Thread producerThread = new Thread(new Producer_Q20(queue));
        Thread consumerThread = new Thread(new Consumer_Q20(queue));
        
        // Start the threads
        producerThread.start();
        consumerThread.start();
        
        // Let the threads run for a while
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Interrupt the threads to stop them
        producerThread.interrupt();
        consumerThread.interrupt();
        
        System.out.println("Main thread exiting.");
    }
}

class Producer_Q20 implements Runnable {
    private final BlockingQueue<Integer> queue;
    private int value = 0;
    
    public Producer_Q20(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                value++; // Generate a new value
                System.out.println("Producer produced: " + value);
                
                // Put the value in the queue - this will block if the queue is full
                queue.put(value);
                
                // Sleep for a bit to simulate work
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Producer was interrupted.");
        }
    }
}

class Consumer_Q20 implements Runnable {
    private final BlockingQueue<Integer> queue;
    
    public Consumer_Q20(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // Take a value from the queue - this will block if the queue is empty
                int value = queue.take();
                
                System.out.println("Consumer consumed: " + value);
                
                // Sleep for a bit to simulate work
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer was interrupted.");
        }
    }
} 