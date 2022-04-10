package com.redi.j2.utils;

import java.time.LocalDateTime;

public class AppointmentProxy extends ReflectionProxy implements Comparable{

    public AppointmentProxy(String title, LocalDateTime date, Integer duration, String location) {
        super(new Object[]{ title, date, duration, location });
    }

    public AppointmentProxy(Object target) {
        super(target);
    }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.Appointment";
    }

    public String getTitle() {
        return getPropertyValue("title");
    }

    public LocalDateTime getDate() {
        return getPropertyValue("date");
    }

    public Integer getDuration() {
        return getPropertyValue("duration");
    }

    public String getLocation() {
        return getPropertyValue("location");
    }

    public AppointmentProxy clone() {
        return new AppointmentProxy(
                this.getTitle(),
                this.getDate(),
                this.getDuration(),
                this.getLocation()
        );
    }

    @Override
    public int compareTo(Object o) {
        if (getTarget() == null) {
            return 1;
        }
        if (this == o) return -1;
        if (o == null || getClass() != o.getClass()) return -1;

        AppointmentProxy that = (AppointmentProxy) o;
        Integer result = invokeMethod("compareTo", new Class[]{ Object.class }, that.getTarget());
        return (result != null)? result : 0;
    }
}
