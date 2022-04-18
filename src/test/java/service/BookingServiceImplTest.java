package service;

import booking.error.TimeErrorException;
import booking.model.Meet;
import booking.model.Person;
import booking.model.Room;
import booking.service.BookingService;
import booking.service.BookingServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class BookingServiceImplTest {

  private BookingService bookingService;

  @BeforeEach
  void setup() {
    bookingService = new BookingServiceImpl();
  }

  @Test
  void addMeetWithLessThanMinTimeShouldThrowError() {
    Room room = new Room();

    Meet meet =
        Meet.builder()
            .id(1)
            .bookedBy(new Person())
            .start(LocalDateTime.of(2022, 04, 18, 13, 00))
            .end(LocalDateTime.of(2022, 04, 18, 13, 10))
            .build();

    TimeErrorException errorException =
        Assertions.assertThrows(TimeErrorException.class, () -> bookingService.addMeet(meet, room));
    Assertions.assertEquals("Duration not supported by the room", errorException.getMessage());
  }

  @Test
  void addMeetWithOtherMeetAtTheSameTimeShouldThrowError() {
    Room room = new Room();

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
            .start(LocalDateTime.of(2022, 04, 18, 13, 00))
            .end(LocalDateTime.of(2022, 04, 18, 13, 30))
            .build();

    TimeErrorException errorException =
        Assertions.assertThrows(TimeErrorException.class, () -> bookingService.addMeet(meet2, room));
    Assertions.assertEquals("Room is not available at that time", errorException.getMessage());
  }

  @Test
  void addMeetShouldAdd() {
    Room room = new Room();

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
    Assertions.assertEquals(2,room.getMeetList().size());
  }
}
