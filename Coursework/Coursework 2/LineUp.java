public class LineUp{
  private char[] musicians = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
  private char[] lineup;
  public LineUp(char[] lineup){
    this.lineup = lineup;
  }
  public char getMusician(int i){
    return this.lineup[i];
  }
  public String toString(){
    String result = "" + this.lineup[0];
    for(int i = 1; i < this.lineup.length;i++){
      result += " " + lineup[i];
    }
    return result;
  }
}
