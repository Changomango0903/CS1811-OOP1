public class DraftCover{
  private LineUp suggestion, solution;
  private DraftCover next;
  public DraftCover(LineUp suggestion, LineUp solution){
    this.suggestion = suggestion;
    this.solution = solution;
  }

  public DraftCover(LineUp suggestion, LineUp solution, DraftCover next){
    this.suggestion = suggestion;
    this.solution = solution;
    this.next = next;
  }

  public DraftCover getNext(){
    return this.next;
  }

  public LineUp getLineUp(){
    return this.suggestion;
  }

  public String toString(){
    DraftCover current = this;
    if(current.getNext() != null){
      current = current.getNext();
      return this.suggestion + " (Too left " + this.getNumTooLeft() + ", Good " + this.getNumGood() + ", Too right " + this.getNumTooRight() + ")\n" + current.toString();
    }
    else{
    return this.suggestion + " (Too left " + this.getNumTooLeft() + ", Good " + this.getNumGood() + ", Too right " + this.getNumTooRight() + ")";
    }
  }

  public int getNumGood(){
    int good = 0;
    for(int i = 0; i < 6;i++){
      for(int j = 0; j < 6;j++){
        if ((j == i) && (suggestion.getMusician(j) == solution.getMusician(i))){
          good++;
        }
      }
    }
    return good;
  }

  public int getNumTooLeft(){
    int tooLeft = 0;
    for(int i = 0; i < 6;i++){
      for(int j = 0; j < 6;j++){
        if((j<i) && (suggestion.getMusician(j) == solution.getMusician(i))){
          tooLeft++;
        }
      }
    }
    return tooLeft;
  }

  public int getNumTooRight(){
    int tooRight = 0;
for(int i = 0; i < 6; i++){
      for(int j = 0; j < 6; j++){
        if((j>i) && (suggestion.getMusician(j) == solution.getMusician(i))){
          tooRight++;
        }
      }
    }
    return tooRight;
  }

  public boolean isCorrect(){
    if (getNumGood() == 6){
      return true;
    }
    else {
      return false;
    }
  }
}
