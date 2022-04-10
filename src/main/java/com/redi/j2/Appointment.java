package com.redi.j2;

import java.time.LocalDateTime;

public class Appointment implements Comparable{

    private String title;
    private LocalDateTime date;
    private int duration;
    private String location;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Appointment(String title, LocalDateTime date, int duration, String location) {
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.location = location;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Appointment{");
        sb.append("title='").append(title).append('\'');
        sb.append(", date=").append(date);
        sb.append(", duration=").append(duration);
        sb.append(", location='").append(location).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        if (getDuration() != that.getDuration()) return false;
        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) return false;
        if (getDate() != null ? !getDate().equals(that.getDate()) : that.getDate() != null) return false;
        return getLocation() != null ? getLocation().equals(that.getLocation()) : that.getLocation() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + getDuration();
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (! (o instanceof Appointment)) return -1;
        return date.compareTo(((Appointment)o).getDate());
    }
}
