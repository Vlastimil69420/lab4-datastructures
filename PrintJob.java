/**
 * Lab4 - PrintJob
 * A print job for the print server. Holds the job id, the document
 * name and the number of pages. toString() returns the document name.
 *
 * @author Vlastimil Finger (B00176858)
 */

public class PrintJob
{
  private int id;
  private String doc_name;
  private int pages;

  public PrintJob(int newId, String newDocName, int newPages)
  {
    id = newId;
    doc_name = newDocName;
    pages = newPages;
  }

  public String toString()
  {
    return doc_name;
  }
}
