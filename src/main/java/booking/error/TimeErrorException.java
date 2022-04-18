package booking.error;

/**
 * Custom Runtime Exception used in the logic of new meets.
 */
public class TimeErrorException extends RuntimeException{
    public TimeErrorException(String msg) {
        super(msg);
    }
}
