package Hard;
public class Seat {
  private final int seatNumber;
  private boolean isBooked;

  public Seat(int seatNumber) {
      this.seatNumber = seatNumber;
      this.isBooked = false;
  }

  public int getSeatNumber() {
      return seatNumber;
  }

  public synchronized boolean book() {
      if (!isBooked) {
          isBooked = true;
          return true;
      }
      return false;
  }
}
