package com.redi.j2;

import com.redi.j2.utils.AppointmentProxy;
import com.redi.j2.utils.Fixtures;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Step1_AppointmentTest {

    @Test
    void task_1_0_shouldDefineAppointmentClass() {

        // given - a class we want the students to implement
        AppointmentProxy appointment;

        // when - we check if it exists
        appointment = Fixtures.createAppointment();

        // then - it should exist
        assertTrue(appointment.existsClass(), "Appointment class is not defined");
    }

    @Test
    void task_1_1_shouldHaveTitleProperty() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'title' property

        // then - it should exist
        assertTrue(appointment.hasProperty("title"), "Property 'title' is not defined");

        // and - it should have the correct type
        assertTrue(appointment.isPropertyOfType("title", String.class), "Property 'title' should be a String");

        // and - it should have private access
        assertTrue(appointment.isPropertyPrivate("title"), "Property 'title' should have private access");
    }

    @Test
    void task_1_2_shouldHaveDateProperty() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'date' property

        // then - it should exist
        assertTrue(appointment.hasProperty("date"), "Property 'date' is not defined");

        // and - it should have the correct type
        assertTrue(appointment.isPropertyOfType("date", LocalDateTime.class), "Property 'date' should be a LocalDateTime");

        // and - it should have private access
        assertTrue(appointment.isPropertyPrivate("date"), "Property 'date' should have private access");
    }

    @Test
    void task_1_3_shouldHaveDurationProperty() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'duration' property

        // then - it should exist
        assertTrue(appointment.hasProperty("duration"), "Property 'duration' is not defined");

        // and - it should have the correct type
        assertTrue(appointment.isPropertyOfType("duration", int.class), "Property 'duration' should be an int");

        // and - it should have private access
        assertTrue(appointment.isPropertyPrivate("duration"), "Property 'duration' should have private access");
    }

    @Test
    void task_1_4_shouldHaveLocationProperty() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'location' property

        // then - it should exist
        assertTrue(appointment.hasProperty("location"), "Property 'location' is not defined");

        // and - it should have the correct type
        assertTrue(appointment.isPropertyOfType("location", String.class), "Property 'location' should be a String");

        // and - it should have private access
        assertTrue(appointment.isPropertyPrivate("location"), "Property 'location' should have private access");
    }

    @Test
    void task_2_1_shouldHaveGetterForTitle() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'getTitle' method

        // then - it should exist
        assertTrue(appointment.hasMethod("getTitle"), "Method 'getTitle' is not defined");

        // and - it should have the correct return type
        assertTrue(appointment.isMethodReturnType(String.class, "getTitle"), "Method 'getTitle' should return a String");

        // and - it should have public access
        assertTrue(appointment.isMethodPublic("getTitle"), "Method 'getTitle' should be public");
    }

    @Test
    void task_2_1_shouldHaveSetterForTitle() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'setTitle' method

        // then - it should exist
        assertTrue(appointment.hasMethod("setTitle", String.class), "Method 'setTitle' is not defined");

        // and - it should have the correct return type
        assertTrue(appointment.isMethodReturnType(void.class, "setTitle", String.class), "Method 'setTitle' should return void");

        // and - it should have public access
        assertTrue(appointment.isMethodPublic("setTitle", String.class), "Method 'setTitle' should be public");
    }

    @Test
    void task_2_2_shouldHaveGetterForDate() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'getDate' method

        // then - it should exist
        assertTrue(appointment.hasMethod("getDate"), "Method 'getDate' is not defined");

        // and - it should have the correct return type
        assertTrue(appointment.isMethodReturnType(LocalDateTime.class, "getDate"), "Method 'getDate' should return a LocalDateTime");

        // and - it should have public access
        assertTrue(appointment.isMethodPublic("getDate"), "Method 'getDate' should be public");
    }

    @Test
    void task_2_2_shouldHaveSetterForDate() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'setDate' method

        // then - it should exist
        assertTrue(appointment.hasMethod("setDate", LocalDateTime.class), "Method 'setDate' is not defined");

        // and - it should have the correct return type
        assertTrue(appointment.isMethodReturnType(void.class, "setDate", LocalDateTime.class), "Method 'setDate' should return void");

        // and - it should have public access
        assertTrue(appointment.isMethodPublic("setDate", LocalDateTime.class), "Method 'setDate' should be public");
    }

    @Test
    void task_2_3_shouldHaveGetterForDuration() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'getDuration' method

        // then - it should exist
        assertTrue(appointment.hasMethod("getDuration"), "Method 'getDuration' is not defined");

        // and - it should have the correct return type
        assertTrue(appointment.isMethodReturnType(int.class, "getDuration"), "Method 'getDuration' should return an int");

        // and - it should have public access
        assertTrue(appointment.isMethodPublic("getDuration"), "Method 'getDuration' should be public");
    }

    @Test
    void task_2_3_shouldHaveSetterForDuration() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'setDuration' method

        // then - it should exist
        assertTrue(appointment.hasMethod("setDuration", int.class), "Method 'setDuration' is not defined");

        // and - it should have the correct return type
        assertTrue(appointment.isMethodReturnType(void.class, "setDuration", int.class), "Method 'setDuration' should return void");

        // and - it should have public access
        assertTrue(appointment.isMethodPublic("setDuration", int.class), "Method 'setDuration' should be public");
    }

    @Test
    void task_2_4_shouldHaveGetterForLocation() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'getLocation' method

        // then - it should exist
        assertTrue(appointment.hasMethod("getLocation"), "Method 'getLocation' is not defined");

        // and - it should have the correct return type
        assertTrue(appointment.isMethodReturnType(String.class, "getLocation"), "Method 'getLocation' should return a String");

        // and - it should have public access
        assertTrue(appointment.isMethodPublic("getLocation"), "Method 'getLocation' should be public");
    }

    @Test
    void task_2_4_shouldHaveSetterForLocation() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'setLocation' method

        // then - it should exist
        assertTrue(appointment.hasMethod("setLocation", String.class), "Method 'setLocation' is not defined");

        // and - it should have the correct return type
        assertTrue(appointment.isMethodReturnType(void.class, "setLocation", String.class), "Method 'setLocation' should return void");

        // and - it should have public access
        assertTrue(appointment.isMethodPublic("setLocation", String.class), "Method 'setLocation' should be public");
    }

    @Test
    void task_2_5_shouldHaveParametrizedConstructor() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the parametrized constructor

        // then - it should exist
        assertTrue(appointment.hasConstructor(String.class, LocalDateTime.class, int.class, String.class),
                "Constructor is not defined as specified in the exercise");

        // and - it should have public access
        assertTrue(appointment.isConstructorPublic(String.class, LocalDateTime.class, int.class, String.class),
                "The constructor should be public");
    }

    @Test
    void task_3_1_shouldHaveToStringMethod() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'toString' method
        String result = appointment.toString();

        // then - it should exist
        assertTrue(appointment.hasMethod("toString"), "Method 'toString' is not defined");

        // and - it should have the correct return type
        assertTrue(appointment.isMethodReturnType(String.class, "toString"), "Method 'toString' should return a String");

        // and - it should have public access
        assertTrue(appointment.isMethodPublic("toString"), "Method 'toString' should be public");

        // and - it should consider all properties
        assertNotNull(result, "The 'toString' method cannot return null");
        assertTrue(result.contains("title"), "The name of the property 'title' should be present in the returned String");
        assertTrue(result.contains(appointment.getTitle()), "The value of the property 'title' should be present in the returned String");
        assertTrue(result.contains("date"), "The name of the property 'date' should be present in the returned String");
        assertTrue(result.contains(appointment.getDate().toString()), "The value of the property 'date' should be present in the returned String");
        assertTrue(result.contains("duration"), "The name of the property 'duration' should be present in the returned String");
        assertTrue(result.contains("" + appointment.getDuration()), "The value of the property 'duration' should be present in the returned String");
        assertTrue(result.contains("location"), "The name of the property 'location' should be present in the returned String");
        assertTrue(result.contains(appointment.getLocation()), "The value of the property 'location' should be present in the returned String");
    }

    @Test
    void task_3_2_shouldHaveEqualsMethod() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it has the 'equals' method

        // then - it should exist
        assertTrue(appointment.hasMethod("equals", Object.class), "Method 'equals' is not defined");

        // and - it should have the correct return type
        assertTrue(appointment.isMethodReturnType(boolean.class, "equals", Object.class), "Method 'equals' should return a boolean");

        // and - it should have public access
        assertTrue(appointment.isMethodPublic("equals", Object.class), "Method 'equals' should be public");
    }

    @Test
    void task_3_3_shouldReturnTrueForIdenticalObjects() {

        // given - two Appointment instances with same properties
        AppointmentProxy appointment1 = Fixtures.createAppointment();
        AppointmentProxy appointment2 = appointment1.clone();

        // when - we compare the objects with the 'equals' method
        boolean areEqual = appointment1.equals(appointment2);

        // then - it should return true
        assertTrue(areEqual, "Method 'equals' does not return true for two identical objects");
    }

    @Test
    void task_3_3_shouldReturnFalseForNonIdenticalObjects() {

        // given - two Appointment instances with (almost) same properties
        AppointmentProxy appointment1 = Fixtures.createAppointment();
        AppointmentProxy appointment2 = Fixtures.createAppointment(
                appointment1.getTitle(),
                appointment1.getDate(),
                appointment1.getDuration(),
                null
        );

        // when - we compare the objects with the 'equals' method
        boolean areEqual = appointment1.equals(appointment2);

        // then - it should return false
        assertFalse(areEqual, "Method 'equals' does not return true for two identical objects");
    }

    @Test
    void task_4_1_shouldImplementComparableInterface() {

        // given - an Appointment
        AppointmentProxy appointment = Fixtures.createAppointment();

        // when - we check if it implements the 'Comparable' interface

        // then - it should
        assertTrue(appointment.implementsInterface(Comparable.class), "It should implement the Comparable interface");
    }

    @Test
    void task_4_2_shouldFollowNaturalOrderingByDateTime() {

        // given - a List of Appointments
        List<AppointmentProxy> list = new ArrayList<>();

        // and - Appointments with different timings
        AppointmentProxy a1 = Fixtures.createAppointment(null, LocalDateTime.now().plusHours(5), null, null);
        AppointmentProxy a2 = Fixtures.createAppointment(null, LocalDateTime.now().plusHours(2), null, null);
        AppointmentProxy a3 = Fixtures.createAppointment(null, LocalDateTime.now().plusHours(1), null, null);
        list.add(a1);
        list.add(a2);
        list.add(a3);

        // when - we try to order the list using the List.sort method
        Collections.sort(list);

        // then - the list is ordered based on the 'compareTo' implementation
        assertEquals(a3, list.get(0), "Collections.sort was not able to order the Assignments properly ('compareTo' might not be returning a correct value)");
        assertEquals(a2, list.get(1), "Collections.sort was not able to order the Assignments properly ('compareTo' might not be returning a correct value)");
        assertEquals(a1, list.get(2), "Collections.sort was not able to order the Assignments properly ('compareTo' might not be returning a correct value)");
    }
}
