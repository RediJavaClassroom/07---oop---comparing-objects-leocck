package com.redi.j2;

import java.util.*;

public class Calendar {

    private String owner;
    private List<Appointment> appointments;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Calendar(String owner) {
        this.owner = owner;
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment a) {
        if (appointments.contains(a) == false) {
            appointments.add(a);
        }
    }

    public List<Appointment> getAllAppointments() {
        Collections.sort(appointments);
        return appointments;
    }

    public List<Appointment> getAppointmentsOrderByTitle() {
        appointments.sort(Comparator.comparing(Appointment::getTitle));
        return appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calendar calendar = (Calendar) o;

        if (getOwner() != null ? !getOwner().equals(calendar.getOwner()) : calendar.getOwner() != null) return false;
        return Objects.equals(appointments, calendar.appointments);
    }

    @Override
    public int hashCode() {
        int result = getOwner() != null ? getOwner().hashCode() : 0;
        result = 31 * result + (appointments != null ? appointments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Calendar{");
        sb.append("owner='").append(owner).append('\'');
        sb.append(", appointments=").append(appointments);
        sb.append('}');
        return sb.toString();
    }
}
