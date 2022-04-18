package booking.service;

import booking.error.TimeErrorException;
import booking.model.Meet;
import booking.model.Room;
import booking.repository.MeetRepository;

import java.time.temporal.ChronoUnit;

public class BookingServiceImpl implements BookingService {

  private final MeetRepository meetRepository = MeetRepository.getInstance();

  /**
   * Logic for duration of the meet, and check if is available the room in that time.
   * @param meet meet for adding.
   * @param room room to add the meet.
   */
  @Override
  public void addMeet(Meet meet, Room room) {
    Long duration = ChronoUnit.MINUTES.between(meet.getStart(), meet.getEnd());
    if (duration > room.getMinTimeInRoom() && duration < room.getMaxTimeInRoom()) {
      meetRepository.addMeet(meet);
      addMeetToRoom(meet, room);
    } else {
      throw new TimeErrorException("Duration not supported by the room");
    }
  }

  /**
   * Check if the room is available in the time of the meet
   * @param newMeet new meet for adding.
   * @param room room to add the meet.
   */
  private void addMeetToRoom(Meet newMeet, Room room) {
    for (Meet meet : room.getMeetList()) {
      if(((newMeet.getStart().isAfter(meet.getStart()) || newMeet.getStart().isEqual(meet.getStart()))
              && (newMeet.getEnd().isBefore(meet.getEnd()) || newMeet.getEnd().isEqual(meet.getEnd())))) {
        throw new TimeErrorException("Room is not available at that time");
      }
    }
    room.addMeet(newMeet);
  }
}
