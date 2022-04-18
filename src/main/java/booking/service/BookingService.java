package booking.service;

import booking.model.Meet;
import booking.model.Room;

/**
 * Service for booking logic.
 */
public interface BookingService {

    /**
     * Metoth for add and verify meet to a room.
     * @param meet meet for adding.
     * @param room room to add the meet.
     */
    void addMeet(Meet meet, Room room);
}
