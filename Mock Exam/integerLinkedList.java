public class integerLinkedList{
  private int payload;
  private integerLinkedList next;

  public integerLinkedList(int payload, integerLinkedList next){
    this.payload = payload;
    this.next = next;
  }

  public integerLinkedList getNext(){
    return next;
  }
  public int getPayload(){
    return payload;
  }

  public void setNext(integerLinkedList next){
    this.next = next;
  }
  public void setPayload(int payload){
    this.payload = payload;
  }

  public static void main(String args[]){
    System.out.println("Hello");
  }
}


