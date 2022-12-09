import java.util.Scanner;
public class AlbumCoverDesignerCli{
  public static Scanner k = new Scanner(System.in);
  //runs the game
  public static void playGame(AlbumCoverGame game){
    boolean playing = true;
    //Game Loop
    while(playing){
      char[] input = new char[6];
      System.out.println("Previous attempts:");
      //Display Previous Attempts
      if(game.getPreviousDraftCovers() == null){
        System.out.println("No previous attempts.");
      }
      else{
        System.out.println(game.getPreviousDraftCovers());
      }
      //Primary Game function
      System.out.println("Enter line up:");
      String comparison = "ABCDEFGHI";
      int position = 0;
      boolean isValid = true;
      while(position < 6){ //Take User Input
        char musician = k.next().charAt(0);
        if(comparison.indexOf(musician) == -1){ //Input Validation
          isValid = false;
        }
        input[position] = musician;
        position++;
      }
      if(!isValid){ //Input Validation fail
        System.out.println("Invalid line up!");
        continue;
      }
      boolean guessResult = game.testDraftCover(new LineUp(input)); //Solution Validation
      if (guessResult) { //Win Condition
        System.out.println("Congratulations!");
        playing = false;
        break;
      }
      else{ //Fail Condition
        continue;
      }
    }
  }

  public static void main(String[] args){
    playGame(new AlbumCoverGame());
  }
}
