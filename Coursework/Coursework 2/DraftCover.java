public class DraftCover{
  private LineUp suggestion, solution;
  public DraftCover(LineUp suggestion, LineUp solution) {
    this.suggestion = suggestion;
    this.solution = solution;
  }

  //Second constructor to create the LinkedList data structure
  // public DraftCover(LineUp suggestion, LineUp solution, DraftCover next){
  //    this.suggestion = suggestion;
  //    this.solution = solution;
  //    this.next = next;
  // }

  //returns next LinkedList node
  // public DraftCover getNext(){ return this.next; }
  //returns LineUp suggestion object
  public LineUp getLineUp(){ return this.suggestion;}


  //toString which returns all previous instances with recursion
  @Override
  public String toString(){ 
    return this.suggestion + " (Too left " + this.getNumTooLeft() + ", Good " + this.getNumGood() + ", Too right " + this.getNumTooRight() + ")";
  }

  //returns n number of correctly placed musicians
  public int getNumGood(){
    int good = 0;
    for(int i = 0; i < 6;i++){
        if (suggestion.getMusician(i) == solution.getMusician(i)){
          good++;
        }
    }
    return good;
  }

  //returns n number of musicians (i) placed at j < i
  public int getNumTooLeft(){
    int tooLeft = 0;
    for(int i = 0; i < 6;i++){
      for(int j = i; j >= 0;j--){
        if((j<i) && (suggestion.getMusician(j) == solution.getMusician(i))){
          tooLeft++;
        }
      }
    }
    return tooLeft;
  }
  //returns n number of musicians (i) placed at j > i
  public int getNumTooRight(){
    int tooRight = 0;
for(int i = 0; i < 6; i++){
      for(int j = i; j < 6; j++){
        if((j>i) && (suggestion.getMusician(j) == solution.getMusician(i))){
          tooRight++;
        }
      }
    }
    return tooRight;
  }

  //if isGood == 6, returns true
  public boolean isCorrect(){
    if (getNumGood() == 6){
      return true;
    }
    else {
      return false;
    }
  }
}
