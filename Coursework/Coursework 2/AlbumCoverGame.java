import java.util.random.*;
public class AlbumCoverGame{
  private LineUp solution;
  private DraftCover cursor;


  // public AlbumCoverGame(){
  //   char[] lineup = new char[6];
  //   boolean empty = true;
  //   while(empty){
  //     int randPos = (int)(Math.random()*6);
  //     char randChar = (char)('A' + Math.random()*9);
  //     boolean repeat = false;
  //     empty = false;
  //     for(char l : lineup){
  //       if(l == '\u0000'){
  //         empty = true;
  //       }
  //       if(l == randChar){
  //         repeat = true;
  //       }
  //     }
  //     if(!repeat){
  //       lineup[randPos] = randChar;
  //     }
  //   }
  //
  //   this.solution = new LineUp(lineup);
  //   for(char l : lineup){
  //     System.out.println(l);
  //   }
  // }

  //Construct AlbumCoverGame with LineUp object
  public AlbumCoverGame(LineUp solution){
    this.solution = solution;
  }
  
  public boolean testDraftCover(LineUp suggestion){
    cursor = new DraftCover(suggestion, this.solution, cursor);
    if(cursor.getNumGood() == 6){
      return true;
    }
    else{
      return false;
    } 
  }

  public DraftCover getPreviousDraftCovers(){ return cursor; }

  public LineUp getSolution(){
    return solution;
  }

  public static void main(String[] args){
      char[] c0 = new char[] { 'F', 'C', 'D', 'A', 'I', 'H' };
      LineUp lu0 = new LineUp(c0);
      AlbumCoverGame acg0 = new AlbumCoverGame(lu0);
      char[] c1 = new char[] { 'C', 'A', 'H', 'F', 'I', 'B' };
      LineUp lu1 = new LineUp(c1);
      boolean b0 = acg0.testDraftCover(lu1);
      char[] c2 = new char[] { 'C', 'A', 'B', 'H', 'I', 'G' };
      LineUp lu2 = new LineUp(c2);
      boolean b1 = acg0.testDraftCover(lu2);
      // The type of ldc0 was inferred from your definition of
      // getPreviousDraftCovers. The tester has not verified it.
      DraftCover ldc0 = acg0.getPreviousDraftCovers();
      String s0 = ldc0.toString(); 
      System.out.println(s0);
  }
}
