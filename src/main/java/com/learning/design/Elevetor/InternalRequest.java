package com.learning.design.Elevetor;

public class InternalRequest {
  int destinationFloor;

  public InternalRequest(int i) {
    this.destinationFloor=i;
  }

  public int getDestinationFloor() {
    return destinationFloor;
  }

  public void setDestinationFloor(int destinationFloor) {
    this.destinationFloor = destinationFloor;
  }
}
