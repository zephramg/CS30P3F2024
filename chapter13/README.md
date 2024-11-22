# Ch. 13 CSE3110 - Iterative Algorithms 1
**Zephram Gilson - CS30 Fall 2024**

### Overview of Skillbuilders and Mastery Projects
---
> ### **Skillbuilders** - Stack, Queue, and Linked List implementation
---
- **Stack2**  
  *Implementation of a stack data structure for `Object` type.*  
  The `Stack2` class can store objects of any class, as `Object` is the superclass of all classes in Java.
  
  - **Classes**:
    - `Stack2`
    - `Stack2Demo` — Demonstrates the functionality of `Stack2`.

- **Stack3**  
  *Stack implementation using an ArrayList.*  
  This variation of stack uses an `ArrayList` for internal storage.
  
  - **Classes**:
    - `Stack3`
    - `Stack3Demo` — Demonstrates the functionality of `Stack3`.

- **Queue2**  
  *Queue data structure for `Object` type.*  
  Similar to `Stack2`, `Queue2` can hold objects of any type due to its use of the `Object` superclass.
  
  - **Classes**:
    - `Queue2`
    - `Queue2Demo` — Demonstrates the functionality of `Queue2`.

- **Queue3**  
  *Queue implementation using an ArrayList.*  
  This variation of queue is built on an `ArrayList` for internal storage.
  
  - **Classes**:
    - `Queue3`
    - `Queue3Demo` — Demonstrates the functionality of `Queue3`.

- **LinkedList**  
  *Implementation of a linked list data structure with basic operations.*  
  The `LinkedList` class allows adding, removing, and retrieving elements. The `Node` class, nested within `LinkedList`, represents each element in the list and stores data along with a reference to the next node.
  
  - **Classes**:
    - `LinkedList` — Provides methods to add items at the front or end, remove items, get size, and clear the list.
    - `Node` — Represents each element in `LinkedList`, storing data and a reference to the next node.
    - `LinkedListDemo` — Demonstrates the functionality of `LinkedList`.
---
> ### **Mastery** (includes reflection logs and error logs)
---
- **StackList**  
  *Implementation of a stack using a linked list.*  
  This stack variation uses a linked list structure for dynamic storage and includes standard stack operations (`push`, `pop`, `peek`, and `isEmpty`).
  
  - **Classes**:
    - `StackList` — Stack implementation with methods specific to linked list-backed stacks.
    - `StackListDemo` — Demonstrates stack operations and exception handling for an empty stack scenario.
     
- **ReverseList**  
  *Reverses a list of integers using a stack.*  
  This program uses a `Stack` to reverse the order of integers entered by the user. The user can enter up to 10 numbers or stop early by entering `999`.

  - **Classes**:
    - `ReverseList` — Implements the logic to read up to 10 integers, store them in a stack, and then reverse the order of the numbers by popping from the stack.
   
- **QueueList**  
  *Implementation of a queue using a linked list.*  
  This queue variation uses a linked list structure for dynamic storage and supports standard queue operations (`enqueue`, `dequeue`, `peek`, `isEmpty`, and `getSize`).

  - **Classes**:
    - `QueueList` — Provides queue functionality, with methods for adding, removing, and viewing elements, along with error handling for empty queues.
    - `QueueListDemo` — Demonstrates enqueueing, dequeueing, peeking, and handling exceptions for empty queue scenarios. 
---

### Learning Outcomes

This project covers:
- Iterative algorithm development.
- Data structure fundamentals using stacks, queues, and linked lists.
- Use of `Object` superclass for flexible data storage.
- Comparison of array-based and linked list-based data structures.

---
