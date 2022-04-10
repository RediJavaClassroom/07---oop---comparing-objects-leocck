package com.redi.j2.utils;

import java.util.ArrayList;
import java.util.List;

public class CalendarProxy extends ReflectionProxy {

    public CalendarProxy(String owner) {
        super(new Object[]{ owner });
    }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.Calendar";
    }

    public String getOwner() {
        return getPropertyValue("owner");
    }

    public List<Object> getAppointments() {
        return getPropertyValue("appointments");
    }

    public CalendarProxy clone() {
        CalendarProxy clone = new CalendarProxy(this.getOwner());
        List<Object> appointments = clone.getAppointments();
        if (appointments != null) {
            appointments.clear();
            for(Object appointment : this.getAppointments()) {
                appointments.add(appointment);
            }
        }
        return clone;
    }

    public void addAppointment(AppointmentProxy a) {
        if(getTarget() == null) {
            return;
        }
        invokeMethod("addAppointment",
                new Class[] {a.getTarget().getClass()},
                new Object[] { a.getTarget() });
    }

    public List<AppointmentProxy> getAllAppointments() {
        if(getTarget() == null) {
            return null;
        }
        List<Object> appointments = invokeMethod("getAllAppointments", new Class[]{});
        List<AppointmentProxy> result = new ArrayList<>();
        if(appointments != null) {
            for (Object appointment : appointments) {
                result.add(new AppointmentProxy(appointment));
            }
        }
        return result;
    }

    public List<AppointmentProxy> getAppointmentsOrderByTitle() {
        if(getTarget() == null) {
            return null;
        }
        List<Object> appointments = invokeMethod("getAppointmentsOrderByTitle", new Class[]{});
        List<AppointmentProxy> result = new ArrayList<>();
        if(appointments != null) {
            for (Object appointment : appointments) {
                result.add(new AppointmentProxy(appointment));
            }
        }
        return result;
    }
}
