public class binaryTree{
  private binaryTree leftNode, rightNode;
  private int payload;

  public binaryTree(int payload){
    this.payload = payload;
  }

  public void addLeftNode(binaryTree node){
    leftNode = node;
  }
  public void addRightNode(binaryTree node){
    rightNode = node;
  }
  public void setPayload(int payload){
    this.payload = payload;
  }

  public int getPayload(){
    return payload;
  }
  public binaryTree getLeftNode(){
    return leftNode;
  }
  public binaryTree getRightNode(){
    return rightNode;
  }

  public void preOrder(){
    binaryTree cursor = this;
    System.out.println(cursor.getPayload());
    if (cursor.getLeftNode() != null) cursor.getLeftNode().preOrder();
    else if(cursor.getRightNode() != null) cursor.getRightNode().preOrder();
  }
  public void inOrder(){
    binaryTree cursor = this;
    if(cursor.getLeftNode()!=null) cursor.getLeftNode().inOrder();
    System.out.println(cursor.getPayload());
    if(cursor.getRightNode()!=null) cursor.getRightNode().inOrder();
  }
  public void postOrder(){
    binaryTree cursor = this;
    if(cursor.getLeftNode()!=null) cursor.getLeftNode().postOrder();
    if(cursor.getRightNode()!=null) cursor.getRightNode().postOrder();
    cursor.getPayload();
  }
}
