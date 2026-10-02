public class ProducerConsumer {
    public static void main(String[] args) {
        System.out.println("Producer Consumer Problem");
        System.out.println("-----------------------");
        
        // Create shared buffer
        Buffer buffer = new Buffer();
        
        // Create producer and consumer threads
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));
        
        // Start threads
        producerThread.start();
        consumerThread.start();
        
        // Let the threads run for a while
        try {
            Thread.sleep(10000); // Run for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Interrupt the threads to stop them
        producerThread.interrupt();
        consumerThread.interrupt();
        
        System.out.println("Main thread exiting.");
    }
}

// Shared buffer class
class Buffer {
    private int data;
    private boolean available = false;
    
    // Method for producer to put data
    public synchronized void put(int value) {
        // Wait until consumer consumes the previous value
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        
        // Produce data
        data = value;
        available = true;
        System.out.println("Producer produced: " + value);
        
        // Notify consumer
        notify();
    }
    
    // Method for consumer to get data
    public synchronized int get() {
        // Wait until producer puts a value
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return -1;
            }
        }
        
        // Consume data
        available = false;
        System.out.println("Consumer consumed: " + data);
        
        // Notify producer
        notify();
        
        return data;
    }
}

// Producer class
class Producer implements Runnable {
    private Buffer buffer;
    
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 1; !Thread.currentThread().isInterrupted(); i++) {
                buffer.put(i);
                Thread.sleep(1000); // Produce every 1 second
            }
        } catch (InterruptedException e) {
            // Thread interrupted, exit gracefully
            System.out.println("Producer thread interrupted.");
        }
    }
}

// Consumer class
class Consumer implements Runnable {
    private Buffer buffer;
    
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                buffer.get();
                Thread.sleep(1500); // Consume every 1.5 seconds
            }
        } catch (InterruptedException e) {
            // Thread interrupted, exit gracefully
            System.out.println("Consumer thread interrupted.");
        }
    }
} 