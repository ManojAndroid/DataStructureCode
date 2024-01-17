package com.learning.design.Elevetor;

public class ProcessJobWorker implements Runnable {
  private Elevator elevator;

  ProcessJobWorker(Elevator elevator) {
    this.elevator = elevator;
  }

  @Override
  public void run() {
    /**
     * start the elevator
     */
    elevator.startElevator();
  }

}
