package mastery.QueueList;

public class QueueListDemo {
    public static void main(String[] args) {
        QueueList queue = new QueueList();
        
        System.out.println("Enqueuing elements: A, B, C, D");
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        
        System.out.println("Current queue size: " + queue.getSize());  // Expected: 4
        System.out.println("Peek front element: " + queue.peek());      // Expected: A
        
        System.out.println("\nDequeuing elements:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("Queue size after dequeue: " + queue.getSize());
            if (!queue.isEmpty()) {
                System.out.println("Peek next front element: " + queue.peek());
            }
        }
        
        // Test dequeue on empty queue 
        try {
            System.out.println("\nAttempting to dequeue from an empty queue...");
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        // Test peek on empty queue
        try {
            System.out.println("\nAttempting to peek at an empty queue...");
            queue.peek();
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        System.out.println("Final queue size: " + queue.getSize());  // Expected: 0
    }
}
