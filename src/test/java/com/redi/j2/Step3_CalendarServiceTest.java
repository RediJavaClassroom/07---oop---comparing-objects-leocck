package com.redi.j2;

import com.redi.j2.utils.AppointmentProxy;
import com.redi.j2.utils.CalendarProxy;
import com.redi.j2.utils.CalendarServiceProxy;
import com.redi.j2.utils.Fixtures;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Step3_CalendarServiceTest {

    @Test
    void task_1_0_shouldDefineCalendarClass() {

        // given - a class we want the students to implement
        CalendarServiceProxy calendarService;

        // when - we check if it exists
        calendarService = Fixtures.createCalendarService();

        // then - it should exist
        assertTrue(calendarService.existsClass(), "CalendarService class is not defined");
    }

    @Test
    void task_1_1_shouldHaveCalendarsProperty() {

        // given - a CalendarService
        CalendarServiceProxy calendarService = Fixtures.createCalendarService();
        CalendarProxy calendar = Fixtures.createCalendar();

        // when - we check if it has the 'calendars' property

        // then - it should exist
        assertTrue(calendarService.hasProperty("calendars"), "Property 'calendars' is not defined");

        // and - it should have the correct type
        assertTrue(calendarService.isPropertyOfType("calendars", List.class, calendar.getTarget().getClass()), "Property 'calendars' should be a List<Appointment>");

        // and - it should have private access
        assertTrue(calendarService.isPropertyPrivate("calendars"), "Property 'calendars' should have private access");
    }

    @Test
    void task_1_1_shouldNotHaveGetterForCalendars() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();

        // when - we check if it has the 'getCalendars' method

        // then - it should not exist
        assertFalse(calendar.hasMethod("getCalendars"), "Method 'getCalendars' should not be defined");
    }

    @Test
    void task_1_1_shouldNotHaveSetterForCalendars() {

        // given - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();

        // when - we check if it has the 'setCalendars' method

        // then - it should not exist
        assertFalse(calendar.hasMethod("setCalendars", List.class), "Method 'setCalendars' should not be defined");
    }

    @Test
    void task_1_2_shouldHaveNoArgsConstructor() {

        // given - a CalendarService
        CalendarServiceProxy calendarService = Fixtures.createCalendarService();

        // when - we check if it has a no-args constructor

        // then - it should exist
        assertTrue(calendarService.hasConstructor(),
                "Constructor is not defined as specified in the exercise");

        // and - it should have public access
        assertTrue(calendarService.isConstructorPublic(),
                "The constructor should be public");
    }

    @Test
    void task_1_2_shouldInitializeCalendarsProperty() {

        // given - a CalendarService
        CalendarServiceProxy calendarService;

        // when - we create an instance of it using the no-args constructor
        calendarService = new CalendarServiceProxy();

        // then - the list of calendars should be empty
        List<Object> calendars = calendarService.getCalendars();
        assertNotNull(calendars, "The list of calendars should be initialized");
        assertEquals(0, calendars.size(), "The list of calendars should start empty");
    }

    @Test
    void task_1_3_shouldHaveAddCalendarMethod() {

        // given - a CalendarService
        CalendarServiceProxy calendarService = Fixtures.createCalendarService();

        // and - a Calendar
        CalendarProxy calendar = Fixtures.createCalendar();

        // and - the Calendar class was implemented
        assertNotNull(calendar.getTarget(), "Class 'Calendar' needs to be implemented");

        // when - we check if it has the 'addCalendar' method

        // then - it should exist
        assertTrue(calendarService.hasMethod("addCalendar", calendar.getTarget().getClass()), "Method 'addCalendar' is not defined");

        // and - it should have the correct return type
        assertTrue(calendarService.isMethodReturnType(void.class, "addCalendar", calendar.getTarget().getClass()), "Method 'addCalendar' should return void");

        // and - it should have public access
        assertTrue(calendarService.isMethodPublic("addCalendar", calendar.getTarget().getClass()), "Method 'addCalendar' should be public");
    }

    @Test
    void task_1_3_shouldAddCalendarsToService() {

        // given - a CalendarService
        CalendarServiceProxy calendarService = Fixtures.createCalendarService();

        // when - we add calendars to it
        CalendarProxy c1 = Fixtures.createCalendar();
        CalendarProxy c2 = Fixtures.createCalendar();
        CalendarProxy c3 = Fixtures.createCalendar();
        calendarService.addCalendar(c1);
        calendarService.addCalendar(c2);
        calendarService.addCalendar(c3);

        // then - the service should have all calendars added
        List<Object> calendars = calendarService.getCalendars();
        assertNotNull(calendars, "The list of calendars should be initialized");
        assertEquals(3, calendars.size(), "The method 'addCalendar' is not adding the calendars to the List");
    }

    @Test
    void task_1_3_shouldNotAddIdenticalCalendarsToService() {

        // given - a CalendarService with a Calendar
        CalendarServiceProxy calendarService = Fixtures.createCalendarService();
        CalendarProxy c1 = Fixtures.createCalendar();
        calendarService.addCalendar(c1);

        // when - we try to add an identical calendar
        CalendarProxy c2 = c1.clone();
        calendarService.addCalendar(c2);

        // then - the calendar should not have added the identical object
        List<Object> calendars = calendarService.getCalendars();
        assertNotNull(calendars, "The list of calendars should be initialized");
        assertEquals(1, calendars.size(), "The method 'addCalendar' should not add duplicates to the list");
    }

    @Test
    void task_1_4_shouldHaveGetAppointmentsOrderByDateAndOwnerMethod() {

        // given - a Calendar
        CalendarServiceProxy calendarService = Fixtures.createCalendarService();
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'getAppointmentsOrderByDateAndOwner' method

        // then - it should exist
        assertTrue(calendarService.hasMethod("getAppointmentsOrderByDateAndOwner"), "Method 'getAppointmentsOrderByDateAndOwner' is not defined");

        // and - it should have the correct return type
        assertTrue(calendarService.isMethodReturnType(List.class, appointment.getTarget().getClass(), "getAppointmentsOrderByDateAndOwner"), "Method 'getAppointmentsOrderByDateAndOwner' should return a List<Appointment>");

        // and - it should have public access
        assertTrue(calendarService.isMethodPublic("getAppointmentsOrderByDateAndOwner"), "Method 'getAppointmentsOrderByDateAndOwner' should be public");
    }

    @Test
    void task_1_4_shouldSortAppointmentsByDateAndOwner() {

        // given - a CalendarService
        CalendarServiceProxy calendarService = Fixtures.createCalendarService();

        // and - a Calendar with appointments
        CalendarProxy c1 = Fixtures.createCalendar("John Doe");
        AppointmentProxy c1a1 = Fixtures.createAppointment("Meeting 1", LocalDateTime.of(2021, 12, 6, 10, 0), null, null);
        AppointmentProxy c1a2 = Fixtures.createAppointment("Meeting 2", LocalDateTime.of(2021, 10, 6, 10, 0), null, null);
        AppointmentProxy c1a3 = Fixtures.createAppointment("Meeting 3", LocalDateTime.of(2021, 11, 6, 10, 0), null, null);
        c1.addAppointment(c1a1);
        c1.addAppointment(c1a2);
        c1.addAppointment(c1a3);
        calendarService.addCalendar(c1);

        // and - another Calendar with different owner and colliding appointments
        CalendarProxy c2 = Fixtures.createCalendar("Ana Doe");
        AppointmentProxy c2a1 = Fixtures.createAppointment("Meeting 4", LocalDateTime.of(2021, 11, 6, 10, 0), null, null);
        AppointmentProxy c2a2 = Fixtures.createAppointment("Meeting 5", LocalDateTime.of(2021, 10, 6, 10, 0), null, null);
        AppointmentProxy c2a3 = Fixtures.createAppointment("Meeting 6", LocalDateTime.of(2021, 9, 6, 10, 0), null, null);
        c2.addAppointment(c2a1);
        c2.addAppointment(c2a2);
        c2.addAppointment(c2a3);
        calendarService.addCalendar(c2);

        // when - you call the 'getAppointmentsOrderByDateAndOwner' method
        List<AppointmentProxy> appointments = calendarService.getAppointmentsOrderByDateAndOwner();

        // then - the resulting list should be sorted by 'date' and 'owner'
        assertNotNull(appointments, "The 'getAppointmentsOrderByDateAndOwner' should return a list of Appointments");
        assertEquals(6, appointments.size(), "The 'getAppointmentsOrderByDateAndOwner' should return a list with all Appointments from all Calendars");
        assertEquals(c2a3, appointments.get(0), "The 'getAppointmentsOrderByDateAndOwner' should return a list of Appointments ordered by 'date' and 'owner");
        assertEquals(c2a2, appointments.get(1), "The 'getAppointmentsOrderByDateAndOwner' should return a list of Appointments ordered by 'date' and 'owner");
        assertEquals(c1a2, appointments.get(2), "The 'getAppointmentsOrderByDateAndOwner' should return a list of Appointments ordered by 'date' and 'owner");
        assertEquals(c2a1, appointments.get(3), "The 'getAppointmentsOrderByDateAndOwner' should return a list of Appointments ordered by 'date' and 'owner");
        assertEquals(c1a3, appointments.get(4), "The 'getAppointmentsOrderByDateAndOwner' should return a list of Appointments ordered by 'date' and 'owner");
        assertEquals(c1a1, appointments.get(5), "The 'getAppointmentsOrderByDateAndOwner' should return a list of Appointments ordered by 'date' and 'owner");
    }
}
