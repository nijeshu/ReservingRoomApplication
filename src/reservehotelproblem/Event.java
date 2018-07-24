package reservehotelproblem;

public class Event implements Comparable<Event> {

    private int RequestNumber;
    private int CustomerNumber;
    private int GroupSize;
    private int StartTime;
    private int Duration;

    public Event() {
        RequestNumber = 0;
        CustomerNumber = 0;
        GroupSize = 0;
        StartTime = 0;
        Duration = 0;

    }

    public Event(int r, int c, int g, int s, int d) {
        RequestNumber = r;
        CustomerNumber = c;
        GroupSize = g;
        StartTime = s;
        Duration = d;
    }

    public boolean intersects(Event other) {
        if ((this.StartTime >= other.StartTime + other.Duration) || (StartTime + Duration <= other.StartTime)) {
            return false;
        } else {
            return true;
        }
    }

    public int getStartTime() {
        return StartTime;
    }

    public int getRequestNumber() {
        return RequestNumber;
    }

    public int getDuration() {
        return Duration;
    }

    public int getGroupSize() {
        return GroupSize;
    }

    public interface Comparable<Event> {

        public int compareTo(Event o);
    }

    @Override
    public int compareTo(Event other) {

        if (StartTime + Duration <= other.StartTime) {
            return -1;
        } else if (StartTime >= other.StartTime + other.Duration) {
            return 1;
        } else {
            return 0;
        }
    }

}
