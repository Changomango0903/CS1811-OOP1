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

  //new toString method which iterates through LinkedList
  @Override
  public String toString(){
    String output = ""; //Return String Creation
    output += this.getPayload();
    for(LinkedList cursor = this.getNext(); cursor != null; cursor = cursor.getNext()){ //LinkedList Traversal
      output += "\n" + cursor.getPayload(); //Return String Construction
    }
    return output;
  }
}
