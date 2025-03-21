package Hard;
public class TicketBookingSystem {
  public static void main(String[] args) {
      BookingSystem bookingSystem = new BookingSystem(10);

      Thread vipBooking1 = new Thread(new BookingRequest(bookingSystem, 1, "VIP"));
      Thread vipBooking2 = new Thread(new BookingRequest(bookingSystem, 2, "VIP"));
      Thread regularBooking1 = new Thread(new BookingRequest(bookingSystem, 1, "Regular"));
      Thread regularBooking2 = new Thread(new BookingRequest(bookingSystem, 2, "Regular"));

      vipBooking1.setPriority(Thread.MAX_PRIORITY);
      vipBooking2.setPriority(Thread.MAX_PRIORITY);
      regularBooking1.setPriority(Thread.NORM_PRIORITY);
      regularBooking2.setPriority(Thread.NORM_PRIORITY);

      vipBooking1.start();
      vipBooking2.start();
      regularBooking1.start();
      regularBooking2.start();
  }
}
