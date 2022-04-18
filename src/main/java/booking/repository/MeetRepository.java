package booking.repository;

import booking.model.Meet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Singleton Repository for meets
 */
public class MeetRepository {
  private final Map<Integer, Meet> meetList;

  private static MeetRepository meetRepositoryInstance;

  private MeetRepository() {
    meetList = new HashMap<>();
  }

  public static MeetRepository getInstance() {
    if (Objects.isNull(meetRepositoryInstance)) {
      meetRepositoryInstance = new MeetRepository();
    }
    return meetRepositoryInstance;
  }

  public void addMeet(Meet meet) {
    meetList.put(meet.getId(), meet);
  }

  public Meet getMeet(Integer id) {
    return meetList.get(id);
  }
}
