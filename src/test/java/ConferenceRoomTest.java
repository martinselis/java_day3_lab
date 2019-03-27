import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    private ConferenceRoom conferenceRoom1;
    private Guest guest;

    @Before
    public void setup(){
        conferenceRoom1 = new ConferenceRoom("Diamond", 50);
        guest = new Guest("Jack");
    }

    @Test
    public void getProperties() {
        assertEquals("Diamond", conferenceRoom1.getName());
        assertEquals(50, conferenceRoom1.getCapacity());
        assertEquals(0, conferenceRoom1.getGuestCount());
    }

    @Test
    public void addGuest() {
        conferenceRoom1.addGuest(guest);
        assertEquals(1, conferenceRoom1.getGuestCount());
    }

    @Test
    public void removeGuest() {
        conferenceRoom1.addGuest(guest);
        conferenceRoom1.removeGuest(guest);
        assertEquals(0, conferenceRoom1.getGuestCount());
    }

}
