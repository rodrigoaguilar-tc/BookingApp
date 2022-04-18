package booking.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder
public class Meet {
    @NonNull
    Integer id;
    @NonNull
    LocalDateTime start;
    @NonNull
    LocalDateTime end;
    List<Person> guestList;
    Person bookedBy;
}
