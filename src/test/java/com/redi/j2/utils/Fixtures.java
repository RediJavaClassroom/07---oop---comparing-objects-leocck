package com.redi.j2.utils;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

public class Fixtures {

    private static int ID = 0;
    private static final Random random = new Random();


    public static AppointmentProxy createAppointment() {
        return createAppointment(null, null, null, null);
    }

    public static AppointmentProxy createAppointment(String title, LocalDateTime date, Integer duration, String location) {
        ID++;
        title = Optional.ofNullable(title).orElse("Title "+ID);
        date = Optional.ofNullable(date).orElse(LocalDateTime.now().plusHours(1));
        duration = Optional.ofNullable(duration).orElse(60);
        location = Optional.ofNullable(location).orElse("Location "+ID);
        return new AppointmentProxy(title, date, duration, location);
    }

    public static CalendarProxy createCalendar() {
        return createCalendar(null);
    }

    public static CalendarProxy createCalendar(String owner) {
        ID++;
        owner = Optional.ofNullable(owner).orElse("Owner "+ID);
        return new CalendarProxy(owner);
    }

    public static CalendarServiceProxy createCalendarService() {
        return new CalendarServiceProxy();
    }
}
