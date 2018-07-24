package reservehotelproblem;

import java.util.ArrayList;
import java.util.Collections;

public class Room {

    private ArrayList<Event> E;
    private String RoomName;
    private int RemainingCapacity;

    public Room(String roomName, int capacity) {
        this.RoomName = roomName;
        RemainingCapacity = capacity;
        E = new ArrayList<>();
    }

    public void scheduleEvent(Event p) {
        E.add(p);
    }

    public String getRoomName() {
        return RoomName;
    }

    public boolean canSchedule(Event e) {
        if (e.getGroupSize() <= RemainingCapacity) {
            return true;
        }
        return false;
    }

    public boolean ScheduleEvent(Event p) {
        for (Event a : E) {
            if (a.intersects(p)) {
                return false;
            } else {

            }
        }
        return true;
    }

    public int getEventSize() {
        return E.size();
    }

    public void addEvent(Event a) {
        E.add(a);
    }

    public ArrayList<Event> getEvents() {
        Collections.sort(E);
        return E;
    }

    public int EventSize() {
        return E.size();
    }
}
