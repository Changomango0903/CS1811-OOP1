public class LinkedList{
  private LinkedList next;
  private DraftCover payload;
  //LinkedList Constructor
  public LinkedList(LinkedList next, DraftCover payload){
    this.next = next;
    this.payload = payload;
  }
  //Getter Methods
  public LinkedList getNext() {return this.next;}
  public DraftCover getPayload() {return this.payload;}

  public String toString(){
    String output = "";
    for(LinkedList cursor = this; cursor != null; cursor = cursor.getNext()){
      output += cursor.getPayload() + "\n";
    }
    return output;
  }
}
