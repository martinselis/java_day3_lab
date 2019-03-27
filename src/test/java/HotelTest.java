import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private Guest guest1;
    private Guest guest2;
    private ConferenceRoom conferenceRoom1;
    private ConferenceRoom conferenceRoom2;
    private ConferenceRoom conferenceRoom3;
    private ConferenceRoom conferenceRoom4;
    private Bedroom guestRoom1;
    private Bedroom guestRoom2;

    @Before
    public void setup() {
        conferenceRoom1 = new ConferenceRoom("Java", 50);
        conferenceRoom2 = new ConferenceRoom("Ruby", 2);
        conferenceRoom3 = new ConferenceRoom("Python", 3);
        conferenceRoom4 = new ConferenceRoom("C", 3);
        guest1 = new Guest("Bob");
        guest2 = new Guest("Jim");



        guestRoom1 = new Bedroom(1, 2, "Single");
        guestRoom2 = new Bedroom(2, 1, "Double");
        Bedroom guestRoom3 = new Bedroom(3, 1, "Double");

        ArrayList<ConferenceRoom> conferenceRooms = new ArrayList<>();
        conferenceRooms.add(conferenceRoom1);
        conferenceRooms.add(conferenceRoom2);
        conferenceRooms.add(conferenceRoom3);
        conferenceRooms.add(conferenceRoom4);

        ArrayList<Bedroom> bedrooms = new ArrayList<>();
        bedrooms.add(guestRoom1);
        bedrooms.add(guestRoom2);
        bedrooms.add(guestRoom3);

        this.hotel = new Hotel(conferenceRooms, bedrooms);
    }

    @Test
    public void getProperties() {
        assertEquals(4, hotel.getConferenceRoomCount());
        assertEquals(3, hotel.getBedroomCount());
    }
    @Test
    public void canCheckInConferenceRoom() {
        hotel.checkIn(guest1, "conference room");
        assertEquals(1, conferenceRoom1.getGuestCount());
    }
    @Test
    public void canCheckInBedroom() {
        hotel.checkIn(guest1, "bedroom");
        assertEquals(1, guestRoom1.getGuestCount());
    }
    @Test
    public void canCheckOutFromConferenceRoom() {
        hotel.checkIn(guest1, "conference room");
        hotel.checkIn(guest2, "conference room");
        hotel.checkOut(guest2);


        assertEquals(1, conferenceRoom1.getGuestCount());
    }
    @Test
    public void canCheckOutFromBedroom() {
        hotel.checkIn(guest1, "bedroom");
        hotel.checkIn(guest2, "bedroom");
        hotel.checkOut(guest2);

        assertEquals(1, guestRoom1.getGuestCount());
    }

    @Test
    public void canCreateBooking() {
        Booking completedBooking = hotel.bookRoom(guestRoom1, 5);
        assertEquals(1, completedBooking.getRoomNumber());
    }

    @Test
    public void getVacantBedrooms() {
        hotel.checkIn(guest1, "bedroom");
        assertEquals(2, hotel.getVacantBedrooms().size());
    }

    @Test
    public void canCheckInVacantRoomOnly() {
        hotel.checkIn(guest1, "bedroom");
        hotel.checkIn(guest2, "bedroom");
        assertEquals(1, guestRoom2.getGuestCount());

    }



}
