import java.util.random.*;
public class AlbumCoverGame{
  private LineUp solution;
  private LinkedList cursor;
  //AlbumCoverGame randInt Constructor
  public AlbumCoverGame(){
    char[] lineup = new char[6];
    //Used to ensure no duplicates
    char[] musicians = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
    for(int i = 0; i < lineup.length; i++){ //Random Generation
      while(true){
        int rand = (int)(Math.random()*9); //Random Index Picker
        if(musicians[rand] != '0'){ //Check if index is taken
          lineup[i] = musicians[rand]; 
          musicians[rand] = '0'; //Symbolizes taken letter
          break;
        }
      }
    }
    this.solution = new LineUp(lineup);

  }
  //Construct AlbumCoverGame with LineUp object
  public AlbumCoverGame(LineUp solution){
    this.solution = solution;
  }

  //Getter Methods
  public LinkedList getPreviousDraftCovers(){ return cursor; }
  public LineUp getSolution(){ return solution;}
 
  //Enters User Suggestion + Stores as DraftCover into LinkedList
  public boolean testDraftCover(LineUp suggestion){
    cursor = new LinkedList(cursor ,new DraftCover(suggestion, this.solution)); //Create new LinkedList Node
    if(cursor.getPayload().getNumGood() == 6){ //Check Win Condition
      return true;
    }
    else{
      return false; //Continue condition
    } 
  }


  // --- Testing Purposes ONLY! ---
  // public static void main(String[] args){
  //     char[] c0 = new char[] { 'F', 'C', 'D', 'A', 'I', 'H' };
  //     LineUp lu0 = new LineUp(c0);
  //     AlbumCoverGame acg0 = new AlbumCoverGame(lu0);
  //     char[] c1 = new char[] { 'C', 'A', 'H', 'F', 'I', 'B' };
  //     LineUp lu1 = new LineUp(c1);
  //     boolean b0 = acg0.testDraftCover(lu1);
  //     char[] c2 = new char[] { 'C', 'A', 'B', 'H', 'I', 'G' };
  //     LineUp lu2 = new LineUp(c2);
  //     boolean b1 = acg0.testDraftCover(lu2);
  //     // The type of ldc0 was inferred from your definition of
  //     // getPreviousDraftCovers. The tester has not verified it.
  //     LinkedList ldc0 = acg0.getPreviousDraftCovers();
  //     String s0 = ldc0.toString(); 
  //     System.out.println(s0);
  // }
}
