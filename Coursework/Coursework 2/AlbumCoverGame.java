import java.util.random.*;
public class AlbumCoverGame{
  private LineUp solution;
  private DraftCover cursor;


  public AlbumCoverGame(){
    char[] lineup = new char[6];
    boolean empty = true;
    while(empty){
      int randPos = (int)(Math.random()*6);
      char randChar = (char)('A' + Math.random()*9);
      boolean repeat = false;
      empty = false;
      for(char l : lineup){
        if(l == '\u0000'){
          empty = true;
        }
        if(l == randChar){
          repeat = true;
        }
      }
      if(!repeat){
        lineup[randPos] = randChar;
      }
    }

    this.solution = new LineUp(lineup);
    for(char l : lineup){
      System.out.println(l);
    }
  }

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

  public DraftCover getPreviousDraftCovers(){
    return cursor;
  }

  public LineUp getSolution(){
    return solution;
  }

  public static void main(String[] args){
    AlbumCoverGame test = new AlbumCoverGame();
  }
}
