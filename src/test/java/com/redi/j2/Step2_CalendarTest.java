package com.redi.j2;

import com.redi.j2.utils.AppointmentProxy;
import com.redi.j2.utils.CalendarProxy;
import com.redi.j2.utils.Fixtures;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Step2_CalendarTest {

    @Test
    void task_1_0_shouldDefineCalendarClass() {

        // given - a class we want the students to implement
        CalendarProxy calendar;

        // when - we check if it exists
        calendar = Fixtures.createCalendar();

        // then - it should exist
        assertTrue(calendar.existsClass(), "Calendar class is not defined");
    }

    @Test
    void task_1_1_shouldHaveOwnerProperty() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();

        // when - we check if it has the 'owner' property

        // then - it should exist
        assertTrue(calendar.hasProperty("owner"), "Property 'owner' is not defined");

        // and - it should have the correct type
        assertTrue(calendar.isPropertyOfType("owner", String.class), "Property 'owner' should be a String");

        // and - it should have private access
        assertTrue(calendar.isPropertyPrivate("owner"), "Property 'owner' should have private access");
    }

    @Test
    void task_1_1_shouldHaveGetterForOwner() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();

        // when - we check if it has the 'getOwner' method

        // then - it should exist
        assertTrue(calendar.hasMethod("getOwner"), "Method 'getOwner' is not defined");

        // and - it should have the correct return type
        assertTrue(calendar.isMethodReturnType(String.class, "getOwner"), "Method 'getOwner' should return a String");

        // and - it should have public access
        assertTrue(calendar.isMethodPublic("getOwner"), "Method 'getOwner' should be public");
    }

    @Test
    void task_1_1_shouldHaveSetterForOwner() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();

        // when - we check if it has the 'setOwner' method

        // then - it should exist
        assertTrue(calendar.hasMethod("setOwner", String.class), "Method 'setOwner' is not defined");

        // and - it should have the correct return type
        assertTrue(calendar.isMethodReturnType(void.class, "setOwner", String.class), "Method 'setOwner' should return void");

        // and - it should have public access
        assertTrue(calendar.isMethodPublic("setOwner", String.class), "Method 'setOwner' should be public");
    }

    @Test
    void task_1_2_shouldHaveAppointmentsProperty() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'appointments' property

        // then - it should exist
        assertTrue(calendar.hasProperty("appointments"), "Property 'appointments' is not defined");

        // and - it should have the correct type
        assertTrue(calendar.isPropertyOfType("appointments", List.class, appointment.getTarget().getClass()), "Property 'appointments' should be a List<Appointment>");

        // and - it should have private access
        assertTrue(calendar.isPropertyPrivate("appointments"), "Property 'appointments' should have private access");
    }

    @Test
    void task_1_2_shouldNotHaveGetterForAppointments() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();

        // when - we check if it has the 'getAppointments' method

        // then - it should not exist
        assertFalse(calendar.hasMethod("getAppointments"), "Method 'getAppointments' should not be defined");
    }

    @Test
    void task_1_2_shouldNotHaveSetterForAppointments() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();

        // when - we check if it has the 'setAppointments' method

        // then - it should not exist
        assertFalse(calendar.hasMethod("setAppointments", List.class), "Method 'setAppointments' should not be defined");
    }

    @Test
    void task_2_1_shouldHaveParametrizedConstructor() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();

        // when - we check if it has the parametrized constructor

        // then - it should exist
        assertTrue(calendar.hasConstructor(String.class),
                "Constructor is not defined as specified in the exercise");

        // and - it should have public access
        assertTrue(calendar.isConstructorPublic(String.class),
                "The constructor should be public");
    }

    @Test
    void task_2_1_shouldInitializeAppointmentsProperty() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();

        // when - we check if the list of appointments was initialized
        List<Object> appointments = calendar.getAppointments();

        // then - the list of appointments should be empty
        assertNotNull(appointments, "The list of appointments should be initialized inside the constructor");
        assertEquals(0, appointments.size(), "The list of appointments should start empty");
    }

    @Test
    void task_3_1_shouldHaveEqualsMethod() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();

        // when - we check if it has the 'equals' method
        String result = calendar.toString();

        // then - it should exist
        assertTrue(calendar.hasMethod("equals", Object.class), "Method 'equals' is not defined");

        // and - it should have the correct return type
        assertTrue(calendar.isMethodReturnType(boolean.class, "equals", Object.class), "Method 'equals' should return a boolean");

        // and - it should have public access
        assertTrue(calendar.isMethodPublic("equals", Object.class), "Method 'equals' should be public");
    }

    @Test
    void task_3_1_shouldReturnTrueForIdenticalObjects() {

        // given - two Calendar instances with same properties
        CalendarProxy calendar1 = Fixtures.createCalendar();

        // and - the getAppointments method was implemented
        assertNotNull(calendar1.getAppointments(), "Method 'getAppointments' needs to be implemented");

        // and - an identical calendar instance
        calendar1.getAppointments().add(Fixtures.createAppointment());
        CalendarProxy calendar2 = calendar1.clone();

        // when - we compare the objects with the 'equals' method
        boolean areEqual = calendar1.equals(calendar2);

        // then - it should return true
        assertTrue(areEqual, "Method 'equals' must return true for two identical objects");
    }

    @Test
    void task_3_1_shouldReturnFalseForNonIdenticalObjects() {

        // given - two Calendar instances with (almost) same properties
        CalendarProxy calendar1 = Fixtures.createCalendar();

        // and - the getAppointments method was implemented
        assertNotNull(calendar1.getAppointments(), "Method 'getAppointments' needs to be implemented");

        // and - an almost identical calendar instance
        calendar1.getAppointments().add(Fixtures.createAppointment().getTarget());
        CalendarProxy calendar2 = Fixtures.createCalendar(
                calendar1.getOwner()
        );

        // when - we compare the objects with the 'equals' method
        boolean areEqual = calendar1.equals(calendar2);

        // then - it should return false
        assertFalse(areEqual, "Method 'equals' should return false for two non identical objects");
    }

    @Test
    void task_3_2_shouldHaveToStringMethod() {

        // given - an Appointment
        CalendarProxy calendar = Fixtures.createCalendar();

        // when - we check if it has the 'toString' method
        String result = calendar.toString();

        // then - it should exist
        assertTrue(calendar.hasMethod("toString"), "Method 'toString' is not defined");

        // and - it should have the correct return type
        assertTrue(calendar.isMethodReturnType(String.class, "toString"), "Method 'toString' should return a String");

        // and - it should have public access
        assertTrue(calendar.isMethodPublic("toString"), "Method 'toString' should be public");

        // and - it should consider all properties
        assertNotNull(result, "The 'toString' method cannot return null");
        assertTrue(result.contains("owner"), "The name of the property 'owner' should be present in the returned String");
        assertTrue(result.contains(calendar.getOwner()), "The value of the property 'owner' should be present in the returned String");
        assertTrue(result.contains("appointments"), "The name of the property 'appointments' should be present in the returned String");
        assertTrue(result.contains(calendar.getAppointments().toString()), "The value of the property 'appointments' should be present in the returned String");
    }

    @Test
    void task_3_3_shouldHaveAddAppointmentMethod() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'addAppointment' method

        // then - it should exist
        assertNotNull(appointment.getTarget(), "Class Appointment is not defined");
        assertTrue(calendar.hasMethod("addAppointment", appointment.getTarget().getClass()), "Method 'addAppointment' is not defined");

        // and - it should have the correct return type
        assertTrue(calendar.isMethodReturnType(void.class, "addAppointment", appointment.getTarget().getClass()), "Method 'addAppointment' should return void");

        // and - it should have public access
        assertTrue(calendar.isMethodPublic("addAppointment", appointment.getTarget().getClass()), "Method 'addAppointment' should be public");
    }

    @Test
    void task_3_3_shouldAddAppointmentsToCalendar() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();

        // when - we add appointments to it
        AppointmentProxy a1 = Fixtures.createAppointment(null, LocalDateTime.now().plusHours(5), null, null);
        AppointmentProxy a2 = Fixtures.createAppointment(null, LocalDateTime.now().plusHours(3), null, null);
        AppointmentProxy a3 = Fixtures.createAppointment(null, LocalDateTime.now().plusHours(1), null, null);
        calendar.addAppointment(a1);
        calendar.addAppointment(a2);
        calendar.addAppointment(a3);

        // then - the calendar should have all appointments added
        List<Object> appointments = calendar.getAppointments();
        assertNotNull(appointments, "The list of appointments should be initialized");
        assertEquals(3, appointments.size(), "The method 'addAppointment' is not adding the appointments to the List");
    }

    @Test
    void task_3_3_shouldNotAddIdenticalAppointmentsToCalendar() {

        // given - a Calendar with an appointment
        CalendarProxy calendar = Fixtures.createCalendar();
        AppointmentProxy a1 = Fixtures.createAppointment(null, LocalDateTime.now().plusHours(5), null, null);
        calendar.addAppointment(a1);

        // when - we try to add an identical appointments
        AppointmentProxy a2 = a1.clone();
        calendar.addAppointment(a2);

        // then - the calendar should not have added the identical object
        List<Object> appointments = calendar.getAppointments();
        assertNotNull(appointments, "The list of appointments should be initialized");
        assertEquals(1, appointments.size(), "The method 'addAppointment' should not add duplicates to the list");
    }

    @Test
    void task_3_4_shouldHaveGetAllAppointmentsMethod() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'getAllAppointments' method

        // then - it should exist
        assertTrue(calendar.hasMethod("getAllAppointments"), "Method 'getAllAppointments' is not defined");

        // and - it should have the correct return type
        assertTrue(calendar.isMethodReturnType(List.class, appointment.getTarget().getClass(), "getAllAppointments"), "Method 'getAllAppointments' should return a List<Appointment>");

        // and - it should have public access
        assertTrue(calendar.isMethodPublic("getAllAppointments"), "Method 'getAllAppointments' should be public");
    }

    @Test
    void task_3_4_shouldSortAppointmentsWithCompareTo() {

        // given - a Calendar with some appointments
        CalendarProxy calendar = Fixtures.createCalendar();
        AppointmentProxy a1 = Fixtures.createAppointment(null, LocalDateTime.now().plusHours(5), null, null);
        AppointmentProxy a2 = Fixtures.createAppointment(null, LocalDateTime.now().plusHours(3), null, null);
        AppointmentProxy a3 = Fixtures.createAppointment(null, LocalDateTime.now().plusHours(1), null, null);
        calendar.addAppointment(a1);
        calendar.addAppointment(a2);
        calendar.addAppointment(a3);

        // when - you call the 'getAppointments' method
        List<AppointmentProxy> appointments = calendar.getAllAppointments();

        // then - the resulting list should be sorted by 'date'
        assertNotNull(appointments, "The 'getAppointments' should return a list of Appointments");
        assertEquals(3, appointments.size(), "The 'getAppointments' should return a list with all Appointments");
        assertEquals(a3, appointments.get(0), "The 'getAppointments' should return a list of Appointments ordered by 'date' (making use of the Comparable interface)");
        assertEquals(a2, appointments.get(1), "The 'getAppointments' should return a list of Appointments ordered by 'date' (making use of the Comparable interface)");
        assertEquals(a1, appointments.get(2), "The 'getAppointments' should return a list of Appointments ordered by 'date' (making use of the Comparable interface)");
    }

    @Test
    void task_3_5_shouldHaveGetAppointmentsOrderByTitleMethod() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'getAppointmentsOrderByTitle' method

        // then - it should exist
        assertTrue(calendar.hasMethod("getAppointmentsOrderByTitle"), "Method 'getAppointmentsOrderByTitle' is not defined");

        // and - it should have the correct return type
        assertTrue(calendar.isMethodReturnType(List.class, appointment.getTarget().getClass(), "getAppointmentsOrderByTitle"), "Method 'getAppointmentsOrderByTitle' should return a List<Appointment>");

        // and - it should have public access
        assertTrue(calendar.isMethodPublic("getAppointmentsOrderByTitle"), "Method 'getAppointmentsOrderByTitle' should be public");
    }

    @Test
    void task_3_5_shouldSortAppointmentsWithComparator() {

        // given - a Calendar with some appointments
        CalendarProxy calendar = Fixtures.createCalendar();
        AppointmentProxy a1 = Fixtures.createAppointment("Title B", null, null, null);
        AppointmentProxy a2 = Fixtures.createAppointment("Title C", null, null, null);
        AppointmentProxy a3 = Fixtures.createAppointment("Title A", null, null, null);
        calendar.addAppointment(a1);
        calendar.addAppointment(a2);
        calendar.addAppointment(a3);

        // when - you call the 'getAppointmentsOrderByTitle' method
        List<AppointmentProxy> appointments = calendar.getAppointmentsOrderByTitle();

        // then - the resulting list should be sorted by 'title'
        assertNotNull(appointments, "The 'getAppointmentsOrderByTitle' should return a list of Appointments");
        assertEquals(3, appointments.size(), "The 'getAppointmentsOrderByTitle' should return a list with all Appointments");
        assertEquals(a3, appointments.get(0), "The 'getAppointmentsOrderByTitle' should return a list of Appointments ordered by 'date' (making use of the Comparable interface)");
        assertEquals(a1, appointments.get(1), "The 'getAppointmentsOrderByTitle' should return a list of Appointments ordered by 'date' (making use of the Comparable interface)");
        assertEquals(a2, appointments.get(2), "The 'getAppointmentsOrderByTitle' should return a list of Appointments ordered by 'date' (making use of the Comparable interface)");
    }
}
