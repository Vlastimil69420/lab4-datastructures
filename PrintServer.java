import java.util.Scanner;

/**
 * Lab4 - PrintServer
 * Menu-driven simulation of a print server using QueueArrayBased.
 * Each print job is a PrintJob, and displayQueue() is used to show
 * the jobs waiting in the queue, front to back.
 *
 * @author Vlastimil Finger (B00176858)
 */

public class PrintServer
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    QueueArrayBased queue = new QueueArrayBased();
    boolean quit = false;
    while (!quit)
    {
      displayMenu();
      String choice = in.nextLine().trim();
      switch (choice)
      {
        case "1":
          try
          {
            System.out.print("Enter job id: ");
            int id = Integer.parseInt(in.nextLine().trim());
            System.out.print("Enter document name: ");
            String docName = in.nextLine();
            System.out.print("Enter number of pages: ");
            int pages = Integer.parseInt(in.nextLine().trim());
            queue.enqueue(new PrintJob(id, docName, pages));
          }
          catch (NumberFormatException e)
          {
            System.out.println("Invalid number, job not added.");
          }
          catch (QueueException e)
          {
            System.out.println(e.getMessage());
          }
          break;
        case "2":
          try
          {
            System.out.println("Dequeued: " + queue.dequeue());
          }
          catch (QueueException e)
          {
            System.out.println(e.getMessage());
          }
          break;
        case "3":
          try
          {
            System.out.println("Front of the queue: " + queue.peek());
          }
          catch (QueueException e)
          {
            System.out.println(e.getMessage());
          }
          break;
        case "5":
          queue.displayQueue();
          break;
        case "6":
          quit = true;
          break;
        default:
          System.out.println("Invalid selection, please enter 1-6.");
      }
    }
    in.close();
  }

  /**
   * Prints the menu shown to the user before every selection.
   */
  
  public static void displayMenu()
  {
    System.out.println();
    System.out.println("Welcome to PrintServer! Please select a number from the list.");
    System.out.println("1. Enqueue a job (User enters job details).");
    System.out.println("2. Dequeue a job.");
    System.out.println("3. Peek at the job at front of the queue");
    System.out.println("4. Empty the queue");
    System.out.println("5. Display all jobs.");
    System.out.println("6. Quit the program");
  }
}
