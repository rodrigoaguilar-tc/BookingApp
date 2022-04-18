package booking;

import booking.model.Meet;
import booking.model.Person;
import booking.model.Room;
import booking.service.BookingService;
import booking.service.BookingServiceImpl;

import java.time.LocalDateTime;

/**
 * Main class for program execution, the requested logic was tested in units tests.
 */
public class Main {
  public static void main(String[] args) {
    Room room = new Room();
    BookingService bookingService = new BookingServiceImpl();
    Meet meet =
            Meet.builder()
                    .id(1)
                    .bookedBy(new Person())
                    .start(LocalDateTime.of(2022, 04, 18, 13, 00))
                    .end(LocalDateTime.of(2022, 04, 18, 13, 30))
                    .build();
    bookingService.addMeet(meet,room);
    Meet meet2 =
            Meet.builder()
                    .id(2)
                    .bookedBy(new Person())
                    .start(LocalDateTime.of(2022, 04, 18, 14, 00))
                    .end(LocalDateTime.of(2022, 04, 18, 15, 30))
                    .build();
    bookingService.addMeet(meet2, room);

    System.out.println(room.getMeetList());
  }
}
