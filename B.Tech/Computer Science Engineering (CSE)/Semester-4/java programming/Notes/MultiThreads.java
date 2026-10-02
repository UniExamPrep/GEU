public class MultiThreads {
    public static void main(String[] args) {
        System.out.println("Multi-Threading Example");
        System.out.println("----------------------");
        
        // Create and start CSthread
        Thread csThread = new Thread(new CSThread());
        csThread.setName("CSthread");
        csThread.start();
        
        // Create and start ITthread
        Thread itThread = new Thread(new ITThread());
        itThread.setName("ITthread");
        itThread.start();
        
        // Wait for threads to complete
        try {
            csThread.join();
            itThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        
        System.out.println("Main thread exiting.");
    }
}

// CSThread implementation
class CSThread implements Runnable {
    private int executionCount = 0;
    
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                executionCount++;
                System.out.println(Thread.currentThread().getName() + 
                                   " executing, count: " + executionCount);
                
                // Sleep for 500 milliseconds
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
        
        System.out.println(Thread.currentThread().getName() + " exiting.");
    }
}

// ITThread implementation
class ITThread implements Runnable {
    private int executionCount = 0;
    
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                executionCount++;
                System.out.println(Thread.currentThread().getName() + 
                                   " executing, count: " + executionCount);
                
                // Sleep for 500 milliseconds
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
        
        System.out.println(Thread.currentThread().getName() + " exiting.");
    }
} 