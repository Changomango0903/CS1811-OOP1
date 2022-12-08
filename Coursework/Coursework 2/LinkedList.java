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
    output += this.getPayload();
    for(LinkedList cursor = this.getNext(); cursor != null; cursor = cursor.getNext()){
      output += "\n" + cursor.getPayload();
    }
    return output;
  }
}
