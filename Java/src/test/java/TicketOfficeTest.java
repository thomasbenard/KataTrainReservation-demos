import org.junit.*;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.Assert.*;

public class TicketOfficeTest {

    public static final String TRAIN_ID = "1";
    public static final String COACH = "A";

    @Test
    public void reserveSeats() {

        Train train = new Train(TRAIN_ID);
        Seat expectedSeat = new Seat(COACH, 1);
        List<Seat> listOfSeats = List.of(expectedSeat, new Seat(COACH, 2));
        List<Seat> alreadyReservedSeats = emptyList();
        Coach coach = new Coach(alreadyReservedSeats, listOfSeats);
        train.addCoach(coach);
        FakeTrainRepository trainRepository = new FakeTrainRepository();

        TicketOffice ticketOffice = new TicketOffice(trainRepository);
        ReservationRequest request = new ReservationRequest(TRAIN_ID, 1);
        Reservation reservation = ticketOffice.makeReservation(request);

        assertEquals(reservation.trainId, TRAIN_ID);
        assertEquals(reservation.bookingId, "???"); //TODO d'ou vient ce bookingId ???
        assertEquals(reservation.seats.size(), 1);
        assertEquals(reservation.seats.get(0), expectedSeat);
    }
}
