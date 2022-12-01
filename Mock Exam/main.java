import java.util.Scanner;
public class main extends stringAndIntegerLinkedList{
  public void fileReverse(String fileName){
    Scanner s = new Scanner(fileName);
    while(s.hasNextLine()){
      next = null;
      String sentence;
      while(s.hasNext()){
        sentence = sentence + s.Next();
      }
      stringAndIntegerLinkedList node = new stringAndIntegerLinkedList(sentence, 0, next);
      next = node;
    }
    
  }
}
