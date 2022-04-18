package booking.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private Integer id;
    private List<Meet> meetList = new ArrayList<>();
    private Long maxTimeInRoom = 180L;
    private Long minTimeInRoom = 15L;

    public void addMeet(Meet meet) {
        this.meetList.add(meet);
    }

}
