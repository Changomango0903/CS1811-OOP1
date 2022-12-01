import java.util.LinkedList;
import java.util.Scanner;
public class linkedList{
  private int payload;
  private linkedList next;
  public linkedList(int p, linkedList node){
    payload = p;
    next = node;
  }

  public int getPayload(){
    return payload;
  }

  public linkedList getNext(){
    return next;
  }

  public void setPayload(int p){
    payload = p;
  }

  public void setNext(linkedList node){
    next = node;
  }

  public void printLinkedList(){
    linkedList cursor = this;
    while(cursor != null){
      System.out.println(cursor.getPayload());
      cursor = cursor.getNext();
    }
  }

  public int printRevLinkedList(){
    linkedList cursor = this;
    if (cursor.getNext() == null) return cursor.getPayload();
    else{
      cursor.getNext().printRevLinkedList();
      return cursor.getPayload();
    }
  }


  public static void main(String args[]){
    Scanner s = new Scanner(System.in);
    System.out.println("How many nodes do you want?");
    int nodeCount = s.nextInt();
    linkedList head = null;
    for(int i = 0; i < nodeCount; i++){
      System.out.println("Enter node payload: ");
      int payload = s.nextInt();
      linkedList currentNode = new linkedList(payload, head);
      head = currentNode;
    }
    s.close();
    head.printLinkedList();
    System.out.println(head.printRevLinkedList());
  }
}
