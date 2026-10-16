/**
 * Lab4 - QueueArrayBased
 * Array-based (circular) implementation of the ADT Queue.
 * displayQueue() was added to print the queue horizontally,
 * marking the front and the back, so the contents can be
 * visually confirmed.
 *
 * @author Vlastimil Finger (B00176858)
 */

public class QueueArrayBased implements QueueInterface {
  private final int MAX_QUEUE = 50; // maximum size of queue
  private Object[] items;
  private int front, back, count;
  
  public QueueArrayBased() {
    items = new Object[MAX_QUEUE];  
    front = 0;
    back = MAX_QUEUE-1; 
    count = 0;
  }  // end default constructor

  // queue operations:
  public boolean isEmpty() {
    return count == 0;
  }  // end isEmpty

  public boolean isFull() {
    return count == MAX_QUEUE;
  }  // end isFull
  
  public void enqueue(Object newItem) {
    if (!isFull()) {
      back = (back+1) % (MAX_QUEUE);
      items[back] = newItem;
      ++count;
    }
    else {
      throw new QueueException("QueueException on enqueue: "
                             + "Queue full");
    }  // end if
  }  // end enqueue

  public Object dequeue() throws QueueException {
    if (!isEmpty()) {
      // queue is not empty; remove front
      Object queueFront = items[front];
      front = (front+1) % (MAX_QUEUE);
      --count;
      return queueFront;
    }
    else {
      throw new QueueException("QueueException on dequeue: "+
                              "Queue empty");
    }   // end if
  }  // end dequeue

  public void dequeueAll() {
    items = new Object[MAX_QUEUE];  
    front = 0;
    back = MAX_QUEUE-1;
    count = 0;
  }  // end dequeueAll

  public Object peek() throws QueueException {
    if (!isEmpty()) {  
      // queue is not empty; retrieve front
      return items[front];
    }
    else {
      throw new QueueException("Queue exception on peek: " + 
                              "Queue empty");
    }  // end if
  }  // end peek
   
  /**
   * Prints the queue horizontally, front item first, and marks the
   * front and the back. 
   */
  
  public void displayQueue() {
    if (isEmpty()) {
      System.out.println("Queue: (empty)");
    }
    else {
      System.out.print("Queue: front -> [");
      for (int i = 0; i < count; i++) {
        // the items wrap around the array, so count on from front
        System.out.print(items[(front+i) % MAX_QUEUE]);
        if (i < count-1) {
          System.out.print(", ");
        }
      }  // end for
      System.out.println("] <- back");
    }  // end if
  }  // end displayQueue

} // end QueueArrayBased