public class stringAndIntegerLinkedList extends integerLinkedList{
  private String sPayload;
  public stringAndIntegerLinkedList(String sPayload, int iPayload, integerLinkedList next){
    super(iPayload, next);
    this.sPayload = sPayload;
  }
  public String getSPayload(){
    return sPayload;
  }
  public int getIPayload(){
    return this.getPayload();
  }
  public integerLinkedList getNext(){
    return this.getNext();
  }
  public void setSPayload(String sPayload){
    this.sPayload = sPayload;
  }
}
