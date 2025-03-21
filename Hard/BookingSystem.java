package Hard;
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private final List<Seat> seats;

    public BookingSystem(int numberOfSeats) {
        seats = new ArrayList<>();
        for (int i = 1; i <= numberOfSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public synchronized boolean bookSeat(int seatNumber) {
        if (seatNumber > 0 && seatNumber <= seats.size()) {
            return seats.get(seatNumber - 1).book();
        }
        return false;
    }
}
