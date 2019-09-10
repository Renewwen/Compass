package com.laioffer.matrix;

import java.util.ArrayList;
import java.util.List;

public class DataService {

    public static List<Event> getEventData(int n) {
        List<Event> events = new ArrayList<Event>();
        for (int i = 0; i < n; ++i) {
            events.add(
                    new Event("Event" + (i+1), "1184 W valley Blvd, CA 90101",
                            "This is a huge event"));
        }
        return events;
    }

}


