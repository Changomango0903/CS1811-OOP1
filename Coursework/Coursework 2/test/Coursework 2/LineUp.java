public class LineUp{
  private char[] lineup;
  //LineUp Constructor
  public LineUp(char[] lineup){
    this.lineup = lineup;
  }
  //Return i'th element in char[]
  public char getMusician(int i){
    return this.lineup[i];
  }
  //toString overidden
  @Override
  public String toString(){
    String result = "" + this.lineup[0];
    for(int i = 1; i < this.lineup.length;i++){
      result += " " + lineup[i];
    }
    return result;
  }
}
