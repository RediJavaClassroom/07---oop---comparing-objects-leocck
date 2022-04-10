package com.redi.j2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarService {

    private List<Calendar> calendars;

    public CalendarService() {
        calendars = new ArrayList<>();
    }

    public void addCalendar(Calendar c) {
        if (calendars.contains(c)) return;
        calendars.add(c);
    }

    public List<Appointment> getAppointmentsOrderByDateAndOwner() {

        Map<Appointment, String> ownerMapping = new HashMap<>();
        List<Appointment> allAppointments = new ArrayList<>();

        for (Calendar c : calendars) {
            for (Appointment a: c.getAllAppointments()) {
                ownerMapping.put(a, c.getOwner());
                allAppointments.add(a);
            }
        }

        allAppointments.sort((o1, o2) -> {
            return o1.getDate().compareTo(o2.getDate()) * 10 +
                    ownerMapping.get(o1).compareTo(ownerMapping.get(o2));
        });

        return allAppointments;
    }
}
