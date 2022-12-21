import java.util.List;

public class TicketOffice {

    private final TrainRepository trainRepository;

    public TicketOffice(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public Reservation makeReservation(ReservationRequest request) {
		Train train = trainRepository.getTrainById(request.trainId);
        // TODO implement this
        return new Reservation(request.trainId, List.of(new Seat("A", 1)), "bookingId");
    }

}