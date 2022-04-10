# [OOP 4 - Comparing Objects](https://redi-school.github.io/intermediate-java/07-oop-4-comparing-objects/)

## Exercise

Let's practice the implementation of `equals`, and the usage of `Comparable` and `Comparator`.

### Step 1
1. Create a class `Appointment`, which has the following properties:
    - `String title` - the title of the appointment
    - `LocalDateTime date` - the date and time of the appointment
    - `int duration` - the duration (in minutes)
    - `String location` - the address of the appointment
2. Create getters and setters for all properties and one constructor with parameters (same order as defined on Step 1)
3. Override the default implementations of `toString` and `equals`
    - Consider one appointment is equal to another if all properties have the same value
4. Implement the `Comparable` interface
    - Use the `date` property to define the natural order of the appointments
    
### Step 2
1. Create a class `Calendar`, which has the following properties and methods:
    - `String owner` - the name of the owner, with getter/setter
    - `List<Appointment> appointments` - all the appointments from this calendar, no getter/setter
2. Create a parametrized constructor with the `owner` property
    - The list of appointments should be initialized to an empty List
3. Create the following methods:
    - Override the default `toString` and `equals` method implementations
    - `void addAppointment(Appointment a)` - adds an appointment to the calendar
       - Take advantage of the `equals` implementation to avoid duplicates
    - `List<Appointment> getAllAppointments()` - returns a list with all appointments, ordered by `date`
       - Take advantage of the `compareTo` implementation to sort the resulting list
    - `List<Appointment> getAppointmentsOrderByTitle()` - as the name suggests, returns a list with all appointments, ordered by the `title` property
       - Use the `Comparator` utility class to define the sorting logic
   
### Step 3 (Challenge)

1. Create a class called `CalendarService`, which has the following properties and methods:
   - `List<Calendar> calendars` - a list of calendars, no getter/setter
   - Default no-arg constructor, which initializes the `calendars` to an empty List
   - `void addCalendar(Calendar c)` - adds a Calendar to the list (if it does not exist)
      - Take advantage of the `equals` implementation to avoid duplicates
   - `List<Appointment> getAppointmentsOrderByDateAndOwner()` - returns a list with all appointments, ordered first by `date` and then by `owner`