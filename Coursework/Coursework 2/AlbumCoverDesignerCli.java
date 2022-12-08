import java.util.Scanner;
public class AlbumCoverDesignerCli{
  public static Scanner k = new Scanner(System.in);
  public static void playGame(AlbumCoverGame game){
    boolean playing = true;
    while(playing){
      char[] input = new char[6];
      System.out.println("Previous attempts:");
      if(game.getPreviousDraftCovers() == null){
        System.out.println("No previous attempts.");
      }
      else{
        System.out.println(game.getPreviousDraftCovers());
      }

      System.out.println("Enter line up:");
      String comparison = "ABCDEFGHI";
      int position = 0;
      boolean isValid = true;
      while(position < 6){
        char musician = k.next().charAt(0);
        if(comparison.indexOf(musician) == -1){
          isValid = false;
        }
        input[position] = musician;
        position++;
      }
      if(!isValid){
        System.out.println("Invalid line up!");
        continue;
      }
      boolean guessResult = game.testDraftCover(new LineUp(input));
      if (guessResult) {
        System.out.println("Congratulations!");
        playing = false;
        break;
      }
      else{
        continue;
      }
    }
  }

  public static void main(String[] args){
    playGame(new AlbumCoverGame());
  }
}
