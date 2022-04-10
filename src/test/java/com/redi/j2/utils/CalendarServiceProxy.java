package com.redi.j2.utils;

import java.util.ArrayList;
import java.util.List;

public class CalendarServiceProxy extends ReflectionProxy {

    public CalendarServiceProxy() {
        super();
    }

    public CalendarServiceProxy(Object target) {
        super(target);
    }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.CalendarService";
    }

    public List<Object> getCalendars() {
        return getPropertyValue("calendars");
    }

    public void addCalendar(CalendarProxy c) {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("addCalendar",
                new Class[] {c.getTarget().getClass()},
                new Object[] { c.getTarget() });
    }

    public List<AppointmentProxy> getAppointmentsOrderByDateAndOwner() {
        if(getTarget() == null) {
            return null;
        }
        List<Object> appointments = invokeMethod("getAppointmentsOrderByDateAndOwner", new Class[]{});
        List<AppointmentProxy> result = new ArrayList<>();
        if(appointments != null) {
            for (Object appointment : appointments) {
                result.add(new AppointmentProxy(appointment));
            }
        }
        return result;
    }
}
