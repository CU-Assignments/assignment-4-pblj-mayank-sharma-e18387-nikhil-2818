package Hard;
public class BookingRequest implements Runnable {
  private BookingSystem bookingSystem;
  private int seatNumber;
  private String customerType;

  public BookingRequest(BookingSystem bookingSystem, int seatNumber, String customerType) {
      this.bookingSystem = bookingSystem;
      this.seatNumber = seatNumber;
      this.customerType = customerType;
  }

  @Override
  public void run() {
      boolean success = bookingSystem.bookSeat(seatNumber);
      if (success) {
          System.out.println(customerType + " successfully booked seat " + seatNumber);
      } else {
          System.out.println(customerType + " failed to book seat " + seatNumber + " (already booked)");
      }
  }
}
