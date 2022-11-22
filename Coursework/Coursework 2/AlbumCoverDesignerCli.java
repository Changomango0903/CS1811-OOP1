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
      int position = 0;
      while(position < 6){
        input[position] = k.next().charAt(0);
        position++;
      }
      for (char l : input){
        if (l != 'A' || l != 'B' || l != 'C' || l != 'D' || l != 'E' || l != 'F' || l != 'G' || l != 'H' || l != 'I') {
          System.out.println("Invalid line up!");
          break;
        }
      }
      if (game.testDraftCover(new LineUp(input))) {
        System.out.println("Congratulations!");
        playing = false;
        break;
      }
      else{
        game.testDraftCover(new LineUp(input));
        continue;
      }
    }
  }

  public static void main(String[] args){
    playGame(new AlbumCoverGame());
  }
}
