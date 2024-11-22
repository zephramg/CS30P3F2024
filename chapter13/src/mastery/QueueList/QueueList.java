/*
 
Program: QueueList.java          Last Date of this Revision: November 23, 2024
 
Purpose: A class that implements a queue using a linked list, supporting enqueue, dequeue, peek, and size operations.
 
Author: Zephram Gilson
School: CHHS
Course: Computer Science 30
 
*/

package mastery.QueueList;

public class QueueList {
    private Node front;
    private Node rear;
    private int size;

    // Inner Node class
    private class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public QueueList() {
        front = null;
        rear = null;
        size = 0;
    }

    // Enqueue operation - Adds an item to the rear of the queue
    public void enqueue(Object item) {
        Node newNode = new Node(item);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = newNode;
        }
        size++;
    }

    // Dequeue operation - Removes and returns the item at the front of the queue
    public Object dequeue() {
        if (isEmpty()) {  
            throw new IllegalStateException("Queue is empty");
        }
        Object item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;  // Queue is now empty
        }
        size--;
        return item;
    } 

    // Peek operation - Returns the item at the front of the queue without removing it
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    // isEmpty operation - Checks if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Returns the current size of the queue
    public int getSize() {
        return size;
    }
}
