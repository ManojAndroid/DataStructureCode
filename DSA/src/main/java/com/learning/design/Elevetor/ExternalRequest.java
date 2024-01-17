package com.learning.design.Elevetor;

public class ExternalRequest {
  int sourceFloor;
   Direction directionToGo;

  public ExternalRequest(Direction up, int i) {
    this.directionToGo=up;
    this.sourceFloor=i;
  }

  public int getSourceFloor() {
    return sourceFloor;
  }

  public void setSourceFloor(int sourceFloor) {
    this.sourceFloor = sourceFloor;
  }

  public Direction getDirectionToGo() {
    return directionToGo;
  }

  public void setDirectionToGo(Direction directionToGo) {
    this.directionToGo = directionToGo;
  }
}
