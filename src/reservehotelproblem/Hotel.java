package reservehotelproblem;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(new File("Data.txt"));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }

        Room R[] = new Room[5];
        R[0] = new Room("Grand ballroom", 50);
        R[1] = new Room("Oneida room", 30);
        R[2] = new Room("Michigan room", 20);
        R[3] = new Room("Mendota room", 20);
        R[4] = new Room("Sunrise room", 12);

        while (input.hasNextInt()) {
            int r = input.nextInt();
            int c = input.nextInt();
            int g = input.nextInt();
            int s = input.nextInt();
            int d = input.nextInt();
            Event E = new Event(r, c, g, s, d);

            int counter = 0;
            for (int i = 4; i >= 0; i--) {

                if (R[i].getEventSize() == 0) {
                    if (R[i].canSchedule(E)) {
                        R[i].addEvent(E);
                        break;
                    } else {
                        counter++;
                    }

                } else if (R[i].getEventSize() > 0) {
                    if (R[i].canSchedule(E) && R[i].ScheduleEvent(E)) {
                        R[i].addEvent(E);
                        break;
                    } else {
                        counter++;

                    }
                }

                if (counter == 5) {
                    System.out.println("Can not schedule event number " + E.getRequestNumber());
                }

            }

        }

        System.out.println();

        for (int i = 4; i >= 0; i--) {

            System.out.println(R[i].getRoomName() + ":");

            for (int j =0 ; j < R[i].EventSize(); j++) {
                System.out.println(R[i].getEvents().get(j).getRequestNumber() + ":" + R[i].getEvents().get(j).getStartTime() + "-" + (R[i].getEvents().get(j).getStartTime() + R[i].getEvents().get(j).getDuration()));

            }

        }

    }
}


